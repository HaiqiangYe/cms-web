/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.action.manage;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fjcw.cms.action.ArticleAction;
import com.fjcw.cms.action.ArticleLinkAction;
import com.fjcw.cms.constant.ArticleConstant;
import com.fjcw.cms.constant.MediaConstant;
import com.fjcw.cms.entity.Admin;
import com.fjcw.cms.entity.Article;
import com.fjcw.cms.entity.ArticleLink;
import com.fjcw.cms.entity.Media;
import com.fjcw.cms.entity.vo.AdminVo;
import com.fjcw.cms.entity.vo.ArticleLinkVo;
import com.fjcw.cms.entity.vo.ArticleVo;
import com.fjcw.cms.entity.vo.JsonVo;
import com.fjcw.cms.entity.vo.PageVo;
import com.fjcw.cms.exception.ArticleNotFoundException;
import com.fjcw.cms.exception.FolderNotFoundException;
import com.fjcw.cms.exception.UploadException;
import com.fjcw.cms.util.SSUtils;

/**
 * @author 文件action
 * 
 */
@Controller
@RequestMapping("/manage/articleLink")
public class ManageArticleLinkAction extends ManageBaseAction {

	@Autowired
	private ArticleAction articleAction;
	@Autowired
	private ArticleLinkAction articleLinkAction;

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap,
			@RequestParam(value = "articleId", defaultValue = "0") long articleId)
			throws FolderNotFoundException {
		modelMap.put("articleAll",articleService.getArticleListByPath("8"));
		modelMap.put("articleId", articleId);
		return "manage/articleLink/add";
	}

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<ArticleLink> add(
			@RequestParam("title") String title,
			@RequestParam("type") String type,
			@RequestParam("path") String path,
			@RequestParam("articleId") int articleId,
			@RequestParam(value = "createTime", required = false) String createTime,
			@RequestParam(value = "author", required = false) String author,
			HttpServletRequest request, ModelMap modelMap)
			throws UploadException, ParseException {
		JsonVo<ArticleLink> json = new JsonVo<ArticleLink>();
		try {
			ArticleLink articleLink = articleLinkService.addArticleLink(articleId, title, author, createTime, type, path);
			json.setT(articleLink);
			json.setResult(true);
			return json;
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}

	/**
	 * @author 进入某种文章的列表分页的首页
	 * @throws FolderNotFoundException
	 * @throws ArticleNotFoundException 
	 * 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "0") int p,
			@RequestParam(value = "articleId", defaultValue = "0") long articleId,
			@RequestParam(value = "check", required = false) ArticleConstant.check check,
			HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException, ArticleNotFoundException {
		PageVo<ArticleLinkVo> pageVo = articleLinkService.getArticleListByTypeNull(p,20);
		modelMap.put("pathList", pageVo.getList());
		modelMap.put("articleId", articleId);
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", p);
		return "manage/articleLink/list";
	}

	/**
	 * @author 进入修改文章页面
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "id", defaultValue = "1") long id,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArticleLinkVo article = articleLinkService.getArticleById(id);
		modelMap.put("articleLink", article);
		modelMap.put("articleAll",
				articleService.getArticleListByPath("8"));
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/articleLink/update";
	}

	/**
	 * @author 修改文章资料
	 * @param fileId
	 * @param folderId
	 * @param name
	 * @param titile
	 * @param content
	 * @param description
	 * @param status
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<ArticleLink> update(
			@RequestParam("id") long id,
			@RequestParam("articleId") long articleId,
			@RequestParam("title") String title,
			@RequestParam("author") String author,
			@RequestParam("path") String path,
			@RequestParam(value = "createTime", required = false) String createTime,
			@RequestParam("type") String type,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		JsonVo<ArticleLink> json = new JsonVo<ArticleLink>();
		try {
			ArticleLink article = articleLinkService.updateArticle(id, articleId, title, author, createTime, type, path);
			json.setT(article);
			json.setResult(true);
			return json;
		} catch (UploadException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}

	/**
	 * @author 彻底删除文件
	 * @throws ArticleNotFoundException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> deleteFile(
			@RequestParam(value = "id") long id)
			throws ArticleNotFoundException {
		JsonVo<String> json = new JsonVo<String>();
		// 删除文件系统
		articleLinkService.deleteArticleById(id);
		json.setResult(true);
		return json;
	}



	// @RequestMapping(value = "/preview.htm", method = RequestMethod.GET)
	// public String preview(@RequestParam(value = "articleId") long articleId,
	// @RequestParam(value = "p", defaultValue = "0") int p,
	// ModelMap modelMap, HttpServletRequest request) {
	// return articleAction.folder(articleId, p, modelMap);
	// }

	@RequestMapping(value = "/preview.htm", method = RequestMethod.GET)
	public String preview(@RequestParam(value = "articleId") long articleId,
			@RequestParam(value = "p", defaultValue = "0") int p,
			ModelMap modelMap, HttpServletRequest request) {
		return articleAction.article(articleId, p, modelMap);
	}
}

/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fjcw.cms.dao.ArticleLinkDao;
import com.fjcw.cms.entity.ArticleLink;
import com.fjcw.cms.entity.vo.ArticleLinkVo;
import com.fjcw.cms.entity.vo.ArticleVo;
import com.fjcw.cms.entity.vo.PageVo;
import com.fjcw.cms.exception.ArticleNotFoundException;
import com.fjcw.cms.exception.FolderNotFoundException;
import com.fjcw.cms.exception.UploadException;

/**
 * 
 * 文章服务
 * 
 * @author Zhangjiale
 * 
 */
@Service
public class ArticleLinkService {

	@Autowired
	private ArticleLinkDao articleLinkDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private FolderService folderService;
	@Autowired
	private ArticleService articleService;

	@Autowired
	private MediaService attachmentService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param adminId
	 * @param title
	 * @param summary
	 * @param status
	 * @param content
	 * @param file
	 * @param createTime
	 * @return
	 * @throws FolderNotFoundException
	 * @throws UploadException
	 * @throws IOException
	 */
	@CacheEvict(value = "articleLink", allEntries = true)
	public ArticleLink addArticleLink(long articleId, String title,
			String author, String createTime,String type,String path)
			throws FolderNotFoundException, UploadException,
			IOException {
		ArticleLink articleLink = new ArticleLink();
		Date now = new Date();
		articleLink.setArticleId(articleId);
		articleLink.setTitle(title);
		articleLink.setAuthor(author);
		articleLink.setType(type);
		articleLink.setPath(path);
		if (StringUtils.isBlank(createTime)) {
			articleLink.setCreateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(createTime);
			} catch (ParseException e) {
				date = now;
			}
			articleLink.setCreateTime(date);
		}
		articleLinkDao.addArticleLink(articleLink);
		return articleLinkDao.getArticleLinkById(articleLink.getId());
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @param id
	 * @return boolean
	 */
	@CacheEvict(value = "articleLink", allEntries = true)
	public boolean deleteArticleById(long id) {
		return articleLinkDao.deleteArticleLinkById(id);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param fileId
	 * @param folderId
	 * @param adminId
	 * @param picture
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 * @throws UploadException
	 * @throws ParseException
	 * @throws IOException
	 * @throws FolderNotFoundException 
	 */
	@CacheEvict(value = "articleLink", allEntries = true)
	public ArticleLink updateArticle(long id, long articleId, String title,
			String author, String time,String type,String path) throws UploadException, IOException, FolderNotFoundException {
		Date now = new Date();
		ArticleLinkVo articleLink = articleLinkDao.getArticleLinkById(id);
		articleLink.setArticleId(articleId);
		articleLink.setTitle(title);
		articleLink.setAuthor(author);
		articleLink.setPath(path);
		if(articleId!=0){
			type="article";
		}
		articleLink.setType(type);
		
		if (StringUtils.isBlank(time)) {
			articleLink.setCreateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				date = now;
			}
			articleLink.setCreateTime(date);
		}
		articleLinkDao.updateArticleLink(articleLink);
		return articleLink;
	}



	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 * @throws ArticleNotFoundException
	 */
	@Cacheable(value = "articleLink", key = "'getArticleLinkById_'+#id")
	public ArticleLinkVo getArticleById(long articleId)
			throws ArticleNotFoundException {
		ArticleLinkVo articleVo = articleLinkDao.getArticleLinkById(articleId);
		if (articleVo == null) {
			throw new ArticleNotFoundException(articleId
					+ " 文件，不存在");
		} else {
			return articleVo;
		}
	}

	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 * @throws FolderNotFoundException
	 * @throws ArticleNotFoundException 
	 */
	public List<ArticleLinkVo> getArticleListByArticleId(long articleId) throws FolderNotFoundException, ArticleNotFoundException {
		List<ArticleLinkVo> articlelist = articleLinkDao.getArticleListByArticleId(articleId);
		
		for (ArticleLinkVo artcleLink : articlelist) {
			ArticleVo articleVo = articleService.getArticleById(artcleLink.getArticleId());
					artcleLink.setArticleVo(articleVo);
		}
		return articlelist;
	}
	
	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 * @throws FolderNotFoundException
	 * @throws ArticleNotFoundException 
	 */
	public PageVo<ArticleLinkVo> getArticleListByTypeNull(long offset, long rows) throws FolderNotFoundException, ArticleNotFoundException {
		PageVo<ArticleLinkVo> pageVo = new PageVo<ArticleLinkVo>(20);
		pageVo.setRows(20);
		List<ArticleLinkVo> articlelist = articleLinkDao.getArticleListByTypeNull( offset,  rows);
		pageVo.setList(articlelist);
		pageVo.setPageCount(articlelist.size());
		return pageVo;
	}
	public List<ArticleLinkVo> getArticleListByType(String type){
		return articleLinkDao.getArticleListByType(type);
	}
	

}

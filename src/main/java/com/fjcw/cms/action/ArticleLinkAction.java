/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fjcw.cms.constant.FolderConstant;
import com.fjcw.cms.entity.Folder;
import com.fjcw.cms.entity.vo.ArticleVo;
import com.fjcw.cms.entity.vo.FolderVo;

/**
 * @author fjcw
 * 
 */
@Controller
@RequestMapping("/articleLink")
public class ArticleLinkAction extends BaseAction {

	@RequestMapping(value = "/{id}.htm", method = RequestMethod.GET)
	public String article(@PathVariable long articleId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		try {
			ArticleVo article = fileService.getArticleById(articleId);
			fileService.updateViewCount(articleId, article.getViewCount());
			article = fileService.getArticleById(articleId);
			Long folderId=article.getFolderId();
			Folder folder = folderService.getFolderById(article.getFolderId());
			
			modelMap.addAttribute("currentFolder", folder);
			modelMap.addAttribute("p", p);
			
			modelMap.addAttribute("article", article);
			Long gFolderId=folderService.firstFolderId(folder.getFolderId());
			modelMap.addAttribute("g_folderId", gFolderId);
			modelMap.addAttribute("folder", folderService.getFolderById(gFolderId));
			
			
			// 1//2//3//4
			Long firstFolderId=folderService.firstFolderId(folderId);
			if(firstFolderId!=null){
				modelMap.put("firstFolderPathList", folderService.getFolderListByFatherId(firstFolderId, FolderConstant.status.display));
				modelMap.put("firstFolder", folderService.getFolderById(firstFolderId));
			}else{
				modelMap.put("firstFolderPathList", new ArrayList<FolderVo>());
			}
			//2
			Long secondFolderId=folderService.secondFolderId(folderId);
			if(secondFolderId!=null){
				modelMap.put("secondFolderPathList", folderService.getFolderListByFatherId(secondFolderId, FolderConstant.status.display));
				modelMap.put("secondFolder", folderService.getFolderById(secondFolderId));
			}else{
				modelMap.put("secondFolderPathList", new ArrayList<FolderVo>());
				List<FolderVo> list=folderService.getFolderListByFatherId(firstFolderId, FolderConstant.status.display);
				if(list!=null && list.size()>0){
					modelMap.put("folder", list.get(0));
					modelMap.put("secondFolder", list.get(0));
					secondFolderId=list.get(0).getFolderId();
					modelMap.put("secondFolderPathList", folderService.getFolderListByFatherId(secondFolderId, FolderConstant.status.display));
				}
			}
			//3
			Long threeFolderId=folderService.threeFolderId(folderId);
			if(threeFolderId!=null){
				modelMap.put("threeFolderPathList", folderService.getFolderListByFatherId(threeFolderId, FolderConstant.status.display));
				modelMap.put("threeFolder", folderService.getFolderById(threeFolderId));
			}else{
				if(secondFolderId!=null){
					List list=folderService.getFolderListByFatherId(secondFolderId, FolderConstant.status.display);
					if(list!=null && list.size()>0){
						modelMap.put("folder", list.get(0));
						modelMap.put("threeFolder", list.get(0));	
					}

				}
				
				modelMap.put("threeFolderPathList", new ArrayList<FolderVo>());
			}
			//4
			Long fourFolderId=folderService.fourFolderId(folderId);
			if(fourFolderId!=null){
				modelMap.put("fourFolderPathList", folderService.getFolderListByFatherId(fourFolderId, FolderConstant.status.display));
				modelMap.put("fourFolder", folderService.getFolderById(fourFolderId));
			}else{
				if(threeFolderId!=null){
					List list=folderService.getFolderListByFatherId(threeFolderId, FolderConstant.status.display);
					if(list!=null && list.size()>0){
						modelMap.put("folder", list.get(0));
						modelMap.put("fourFolder", list.get(0));	
					}

				}
				modelMap.put("fourFolderPathList", new ArrayList<FolderVo>());
			}
			
			
			
			return themeService.getArticleTemplate(article.getFolderId(),
					articleId);
		} catch (Exception e) {
			modelMap.addAttribute("g_folderId", 0);
			return themeService.get404();
		}
	}
}

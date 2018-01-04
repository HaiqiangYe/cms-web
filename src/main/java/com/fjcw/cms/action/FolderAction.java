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
import com.fjcw.cms.entity.vo.PageVo;

/**
 * @author fjcw
 * 
 */
@Controller
@RequestMapping("/folder")
public class FolderAction extends BaseAction {

	/**
	 * 目录ID
	 * 
	 * @param ename
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{folderId}.htm", method = RequestMethod.GET)
	public String folder(@PathVariable long folderId,
			@RequestParam(value = "p", defaultValue = "1") long p,
			ModelMap modelMap) {
		try {
			Folder folder = folderService.getFolderById(folderId);
			modelMap.put("folder", folder);
			FolderVo fatherFolder = folderService.getFolderById(folderService.firstFolderId(folderId));
			modelMap.put("g_folderId", fatherFolder.getFolderId());
			modelMap.put("fatherFolder", fatherFolder);
			modelMap.put("p", p);
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
			
			
			
			
			
			return themeService.getFolderTemplate(folder.getFolderId());
		} catch (Exception e) {
			modelMap.addAttribute("g_folderId", 0);
			logger.fatal(e.getMessage());
			return themeService.get404();
		}
	}
	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String top_search(@RequestParam(value = "folderId", defaultValue = "1") long folderId,@RequestParam(value = "key", defaultValue = "") String key,
			@RequestParam(value = "p", defaultValue = "0") long p,
			ModelMap modelMap) {
		try {
			List list=folderService.getFolderListByFatherId(0,FolderConstant.status.display);
			Folder folder = folderService.getFolderById(folderId);
			modelMap.put("folder", folder);
			FolderVo fatherFolder = folderService.getFolderById(folderService.firstFolderId(folderId));
			modelMap.put("g_folderId", 0);
			modelMap.put("fatherFolder", fatherFolder);
			modelMap.put("p", p);
			modelMap.put("key", key);
			// 1//2//3//4
			Long firstFolderId=folderService.firstFolderId(folderId);
			if(firstFolderId!=null){
				modelMap.put("firstFolderPathList", folderService.getFolderListByFatherId(firstFolderId, FolderConstant.status.display));
				modelMap.put("firstFolder", folderService.getFolderById(firstFolderId));
			}else{
				modelMap.put("firstFolderPathList", new ArrayList<FolderVo>());
			}
			
			PageVo<ArticleVo> pageVo=fileService.searchArticleListByKey(folder.getPath(), key, (int)p, 8);
			pageVo.setKey(key);
			pageVo.getArgs().put("folderId", folderId+"");
			modelMap.put("pageVo",pageVo);
			
			
			return "/template/shanggui/search";
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.addAttribute("g_folderId", 0);
			logger.fatal(e.getMessage());
			return themeService.get404();
		}
	}
}

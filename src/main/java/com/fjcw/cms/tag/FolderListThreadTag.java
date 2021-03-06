/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.tag;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjcw.cms.constant.FolderConstant;
import com.fjcw.cms.entity.Folder;
import com.fjcw.cms.entity.vo.FolderVo;
import com.fjcw.cms.exception.FolderNotFoundException;
import com.fjcw.cms.plugin.TagPlugin;
import com.fjcw.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * folder标签
 * 
 * @author lqq
 * 
 */
@Service
public class FolderListThreadTag extends TagPlugin {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		long folderId = 0;
		List<FolderVo> list = new ArrayList<FolderVo>();
		// 获取页面的参数
		try {
			folderId = Long.parseLong(params.get("folderId").toString());
			list = folderService.getFolderListByFatherId(folderService.firstFolderId(folderId),
					FolderConstant.status.display);
		} catch (Exception e) {
			// 丢弃
		}
		env.setVariable("tag_folder_thread_list", DEFAULT_WRAPPER.wrap(list));
		body.render(env.getOut());
	}

}

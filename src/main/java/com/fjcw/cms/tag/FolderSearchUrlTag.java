/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.tag;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjcw.cms.plugin.TagPlugin;
import com.fjcw.cms.service.FolderService;
import com.fjcw.cms.util.HttpUtils;
import com.fjcw.cms.util.PropertyUtils;

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
public class FolderSearchUrlTag extends TagPlugin {
	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String basePath = HttpUtils.getBasePath(request);
		env.getOut().write(basePath + "/folder/search.htm?folderId="+params.get("folderId")+"&key="+params.get("key"));
	}

}

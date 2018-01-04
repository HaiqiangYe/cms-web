/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjcw.cms.entity.vo.ArticleLinkVo;
import com.fjcw.cms.exception.FolderNotFoundException;
import com.fjcw.cms.plugin.TagPlugin;
import com.fjcw.cms.service.ArticleLinkService;
import com.fjcw.cms.service.FolderService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author fjcw
 * 
 */
@Service
public class ArticleLinkListTag extends TagPlugin {

	@Autowired
	private ArticleLinkService articleLinkService;

	@Autowired
	private FolderService folderService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		
		
		// 获取文件的分页
		try {
			List<ArticleLinkVo> articlelist=new ArrayList<ArticleLinkVo>();
			if(!params.containsKey("type")){
				
				Integer articleId = Integer.parseInt(params.get("articleId").toString());
				articlelist = articleLinkService.getArticleListByArticleId(articleId);
			}else{
				articlelist = articleLinkService.getArticleListByType("");
			}
			
			env.setVariable("tag_articlelink_list", BEANS_WRAPPER.wrap(articlelist));
		} catch (Exception e) {
			env.setVariable("tag_articlelink_list", BEANS_WRAPPER.wrap(null));
		}

		body.render(env.getOut());
	}

}

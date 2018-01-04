/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.tag;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjcw.cms.entity.Article;
import com.fjcw.cms.entity.vo.ArticleVo;
import com.fjcw.cms.exception.ArticleNotFoundException;
import com.fjcw.cms.exception.FolderNotFoundException;
import com.fjcw.cms.plugin.TagPlugin;
import com.fjcw.cms.service.ArticleService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author Administrator file标签
 */
@Service
public class ArticleRecTypeTag extends TagPlugin {

	@Autowired
	private ArticleService articleService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取页面的参数
		Integer recType = Integer
				.parseInt(params.get("recType").toString());
		Integer rows = Integer.parseInt(params.get("rows").toString());
		// 获取指定的文件
		try {
			List<ArticleVo> articlelist = articleService.getArticlePageByRecType(recType, 0, rows);
			env.setVariable("tag_article_rec_type_list", BEANS_WRAPPER.wrap(articlelist));
		} catch (FolderNotFoundException e) {
			// TODO Auto-generated catch block
			env.setVariable("tag_article_rec_type_list", BEANS_WRAPPER.wrap(null));
		}
		body.render(env.getOut());
	}
}

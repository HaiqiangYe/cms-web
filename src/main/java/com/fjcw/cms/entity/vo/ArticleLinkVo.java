package com.fjcw.cms.entity.vo;

import com.fjcw.cms.entity.ArticleLink;

public class ArticleLinkVo extends ArticleLink {
	private ArticleVo articleVo=null;

	public ArticleVo getArticleVo() {
		return articleVo;
	}

	public void setArticleVo(ArticleVo articleVo) {
		this.articleVo = articleVo;
	}
	
}

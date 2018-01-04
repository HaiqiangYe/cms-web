/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.entity;

import java.util.Date;

import com.fjcw.cms.constant.ArticleConstant;

/**
 * 文件实体
 * 
 * @author fjcw
 * 
 */

public class ArticleLink {

	/**
	 * 文件Id
	 */
	private long id;

	/**
	 * 关联文章
	 */
	private long articleId;

	/**
	 * 文件名称
	 */
	private String type;

	/**
	 * 文件名称
	 */
	private String title;

	/**
	 * 
	 */
	private String path;
	/**
	 * 作者
	 */
	private String author;


	/**
	 * 创建时间
	 */
	private Date createTime;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getArticleId() {
		return articleId;
	}


	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



}

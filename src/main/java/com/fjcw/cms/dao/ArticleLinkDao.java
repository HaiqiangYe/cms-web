/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fjcw.cms.entity.ArticleLink;
import com.fjcw.cms.entity.vo.ArticleLinkVo;

/**
 * 文件服务
 * 
 * @author Harbored
 * 
 */
@Repository
public interface ArticleLinkDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */
	public int addArticleLink(ArticleLink article);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @return boolean
	 */
	public boolean deleteArticleLinkById(@Param("id") long id);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param article
	 * @return Integer
	 */
	public int updateArticleLink(ArticleLink articleLink);

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param articleId
	 * @return File
	 */
	public ArticleLinkVo getArticleLinkById(@Param("id") long id);

	/**
	 * 得到目录的文件的列表
	 * 
	 * @param foderId
	 * @return List<FileVo>
	 */
	public List<ArticleLinkVo> getArticleListByArticleId(
			@Param("articleId") long articleId);
	
	public List<ArticleLinkVo> getArticleListByTypeNull(@Param("offset")  long offset, @Param("rows") long rows);
	
	public List<ArticleLinkVo> getArticleListByType(
			@Param("type") String type);


}

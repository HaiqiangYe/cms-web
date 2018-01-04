/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.exception;

/**
 * 
 * 目录没有发现异常
 * 
 * @author fjcw
 * 
 */
public class ArticleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleNotFoundException(String msg) {
		super(msg);
	}
}

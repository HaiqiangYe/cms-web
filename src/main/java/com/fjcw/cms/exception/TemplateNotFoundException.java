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
public class TemplateNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TemplateNotFoundException(String msg) {
		super(msg);
	}
}

/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.constant;

/**
 * 附件
 * 
 * @author fjcw
 * 
 */
public class MediaConstant {

	/**
	 * 类型<br>
	 * photo：照片<br>
	 * file：文件<br>
	 * 
	 * @author fjcw
	 * 
	 */
	public static enum Type {
		/**
		 * 相册
		 */
		photo, /**
		 * 文件
		 */
		file, video
	}

	/**
	 * 种类
	 * 
	 * @author fjcw
	 * 
	 */
	public static enum Kind {
		/**
		 * 目录
		 */
		folder, /**
		 * 文章
		 */
		article, /**
		 * 编辑器
		 */
		editor
	}
}

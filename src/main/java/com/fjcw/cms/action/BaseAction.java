/*
 *	
 *	
 *	fjcw
 */
package com.fjcw.cms.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fjcw.cms.service.ArticleLinkService;
import com.fjcw.cms.service.ArticleService;
import com.fjcw.cms.service.FolderService;
import com.fjcw.cms.service.HeadlineService;
import com.fjcw.cms.service.TemplateService;

/**
 * 
 * @author fjcw
 * 
 */
public class BaseAction {

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService fileService;
	
	@Autowired
	protected ArticleLinkService articleLinkService;

	@Autowired
	protected TemplateService themeService;

	@Autowired
	protected HeadlineService headlineService;

	protected final Logger logger = Logger.getLogger(this.getClass());
}

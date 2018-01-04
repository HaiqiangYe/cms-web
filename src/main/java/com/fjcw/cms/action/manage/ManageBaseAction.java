/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.action.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fjcw.cms.constant.SystemConstant;
import com.fjcw.cms.entity.vo.AdminVo;
import com.fjcw.cms.entity.vo.JsonVo;
import com.fjcw.cms.exception.ValidateException;
import com.fjcw.cms.service.AdminFolderService;
import com.fjcw.cms.service.AdminService;
import com.fjcw.cms.service.ArticleLinkService;
import com.fjcw.cms.service.ArticleService;
import com.fjcw.cms.service.ConfigService;
import com.fjcw.cms.service.FolderService;
import com.fjcw.cms.service.HeadlineService;
import com.fjcw.cms.service.MediaService;

/**
 * @author 所有action的父类
 * 
 */
@Controller
public class ManageBaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected ConfigService configService;

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService articleService;
	
	@Autowired
	protected ArticleLinkService articleLinkService;

	@Autowired
	protected MediaService attachmentService;

	@Autowired
	protected AdminService adminService;

	@Autowired
	protected HeadlineService headlineService;

	@Autowired
	protected AdminFolderService adminFolderService;

	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}

	/**
	 * 从session中获得管理员的信息
	 * 
	 * @param request
	 * @return
	 */
	protected AdminVo getAdmin(HttpServletRequest request) {
		AdminVo admin = (AdminVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return admin;
	}
}

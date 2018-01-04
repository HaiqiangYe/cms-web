/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fjcw.cms.constant.ConfigConstant;
import com.fjcw.cms.service.ConfigService;
import com.fjcw.cms.util.HttpUtils;

/**
 * @author fjcw
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	@Autowired
	private ConfigService configService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (null == modelAndView) {
			return;
		}
		// 系统配置参数
		String basePath = HttpUtils.getBasePath(request);
		modelAndView.addObject("BASE_PATH", basePath);
		modelAndView.addObject("UPLOAD_BASE_PATH", basePath + "/upload");
		modelAndView
				.addObject(
						"TEMPLATE_BASE_PATH",
						basePath
								+ "/static/template/"
								+ configService
										.getStringByKey(ConfigConstant.CMS_TEMPLATE));
		modelAndView.addObject("cms_seo_title",
				configService.getStringByKey("cms_seo_title"));
		modelAndView.addObject("cms_seo_description",
				configService.getStringByKey("cms_seo_description"));
		modelAndView.addObject("cms_fax",
				configService.getStringByKey("cms_fax"));
		modelAndView.addObject("cms_address",
				configService.getStringByKey("cms_address"));
		modelAndView.addObject("cms_version",
				configService.getStringByKey("cms_version"));
		modelAndView.addObject("cms_weibo",
				configService.getStringByKey("cms_weibo"));
		modelAndView.addObject("cms_weixin",
				configService.getStringByKey("cms_weixin"));
		modelAndView.addObject("cms_email",
				configService.getStringByKey("cms_email"));
		modelAndView.addObject("cms_title",
				configService.getStringByKey("cms_title"));
		modelAndView.addObject("cms_phone",
				configService.getStringByKey("cms_phone"));
		modelAndView.addObject("cms_nbr",
				configService.getStringByKey("cms_nbr"));
		MDC.put("ip", HttpUtils.getIp(request));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

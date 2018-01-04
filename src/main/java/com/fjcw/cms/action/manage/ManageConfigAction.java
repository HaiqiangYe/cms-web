/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.action.manage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjcw.cms.constant.SystemConstant;
import com.fjcw.cms.entity.Config;
import com.fjcw.cms.entity.vo.JsonVo;
import com.fjcw.cms.util.SSUtils;

/**
 * 网站配置action
 * 
 * @author fjcw
 * 
 */
@Controller
@RequestMapping("/manage/config")
public class ManageConfigAction extends ManageBaseAction {

	/**
	 * 网站配置
	 * 
	 * @author Administrator
	 * 
	 */
	@RequestMapping(value = "/basic.htm", method = RequestMethod.GET)
	public String basic(ModelMap modelMap) {
		List<String> templateList = this.getTemplate();
		modelMap.addAttribute("templateList", templateList);
		List<Config> configs = configService.getConfigs();
		modelMap.put("configs", configs);
		return "manage/config/basic";
	}

	/**
	 * 修改网站配置
	 * 
	 * @author Administrator
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/basic.json", method = RequestMethod.POST)
	public JsonVo<String> basicSubmit(@RequestParam(value = "cms_address")	String cms_address	,
			@RequestParam(value = "cms_email")	String cms_email	,
			@RequestParam(value = "cms_fax")	String cms_fax	,
			@RequestParam(value = "cms_headline_image_height")	String cms_headline_image_height	,
			@RequestParam(value = "cms_headline_image_width")	String cms_headline_image_width	,
			@RequestParam(value = "cms_nbr")	String cms_nbr	,
			@RequestParam(value = "cms_phone")	String cms_phone	,
			@RequestParam(value = "cms_qq")	String cms_qq	,
			@RequestParam(value = "cms_seo_description")	String cms_seo_description	,
			@RequestParam(value = "cms_seo_headline")	String cms_seo_headline	,
			@RequestParam(value = "cms_seo_title")	String cms_seo_title	,
			@RequestParam(value = "cms_static")	String cms_static	,
			@RequestParam(value = "cms_template")	String cms_template	,
			@RequestParam(value = "cms_title")	String cms_title	,
			@RequestParam(value = "cms_version")	String cms_version	,
			@RequestParam(value = "cms_weibo")	String cms_weibo	,
			@RequestParam(value = "cms_weixin")	String cms_weixin	, ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(cms_seo_title)) {
				json.getErrors().put("sitename", "网站名称不能为空");
			}
			if (StringUtils.isBlank(cms_seo_description)) {
				json.getErrors().put("sitedesc", "网站描述不能为空");
			}

			// 检测校验结果
			validate(json);
			configService.updagteConfigByKey("cms_address",SSUtils.toText(cms_address));
			configService.updagteConfigByKey("cms_email",SSUtils.toText(cms_email));
			configService.updagteConfigByKey("cms_fax",SSUtils.toText(cms_fax));
			configService.updagteConfigByKey("cms_headline_image_height",SSUtils.toText(cms_headline_image_height));
			configService.updagteConfigByKey("cms_headline_image_width",SSUtils.toText(cms_headline_image_width));
			configService.updagteConfigByKey("cms_nbr",SSUtils.toText(cms_nbr));
			configService.updagteConfigByKey("cms_phone",SSUtils.toText(cms_phone));
			configService.updagteConfigByKey("cms_qq",SSUtils.toText(cms_qq));
			configService.updagteConfigByKey("cms_seo_description",SSUtils.toText(cms_seo_description));
			configService.updagteConfigByKey("cms_seo_headline",SSUtils.toText(cms_seo_headline));
			configService.updagteConfigByKey("cms_seo_title",SSUtils.toText(cms_seo_title));
			configService.updagteConfigByKey("cms_static",SSUtils.toText(cms_static));
			configService.updagteConfigByKey("cms_template",SSUtils.toText(cms_template));
			configService.updagteConfigByKey("cms_title",SSUtils.toText(cms_title));
			configService.updagteConfigByKey("cms_version",SSUtils.toText(cms_version));
			configService.updagteConfigByKey("cms_weibo",SSUtils.toText(cms_weibo));
			configService.updagteConfigByKey("cms_weixin",SSUtils.toText(cms_weixin));
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;

	}

	@RequestMapping(value = "/picture.htm", method = RequestMethod.GET)
	public String picture() {
		return "system/config/picture";
	}

	@ResponseBody
	@RequestMapping(value = "/update/picture.json", method = RequestMethod.GET)
	public JsonVo<String> updatePicture(
			@RequestParam(value = "bigWidth") String bigWidth,
			@RequestParam(value = "bigheight") String bigheight,
			@RequestParam(value = "smallWidth") String smallWidth,
			@RequestParam(value = "smallHeight") String smallHeight) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(bigWidth)) {
				json.getErrors().put("bigWidth", "大图的宽度不能为空");
			}
			if (StringUtils.isBlank(bigheight)) {
				json.getErrors().put("bigheight", "大图的高度不能为空");
			}
			if (StringUtils.isBlank(smallWidth)) {
				json.getErrors().put("smallWidth", "小图的宽度不能为空");
			}
			if (StringUtils.isBlank(smallHeight)) {
				json.getErrors().put("smallHeight", "小图的高度不能为空");
			}

			// 检测校验结果
			validate(json);
			String strb = bigWidth + "x" + bigheight + ";" + smallWidth + "x"
					+ smallHeight + ";";
			configService.updagteConfigByKey("article_picture_size", strb);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	private List<String> getTemplate() {
		List<String> templateList = new ArrayList<String>();
		String templatePath = SystemConstant.CMS_ROOT + "/WEB-INF/";
		File dir = new File(templatePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory() && !file.getName().equals("admin")) {
				templateList.add(file.getName());
			}
			logger.debug(file.getName());
		}
		return templateList;
	}

}

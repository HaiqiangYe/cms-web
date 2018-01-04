package com.fjcw.cms.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjcw.cms.entity.vo.JsonVo;
import com.fjcw.cms.service.GuestbookService;
import com.fjcw.cms.util.SSUtils;

@Controller
@RequestMapping("/guestbook")
public class GuestbookAction extends BaseAction {

	@Autowired
	private GuestbookService messageBoardService;

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> add(@RequestParam(value = "name") String name,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "content") String content, ModelMap modelMap) {
		
		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(name)) {
				throw new Exception("姓名不能为空");
			}
			if (StringUtils.isBlank(email)) {
				throw new Exception("邮箱不能为空");
			}
			// 检测校验结果
			json.check();
			messageBoardService.addGuestbook(SSUtils.toText(name),
					SSUtils.toText(email), SSUtils.toText(""),
					SSUtils.toText(content));
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
}

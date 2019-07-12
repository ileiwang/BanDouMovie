package xyz.leiwang.bandoumovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:36:55
*/
@Controller
public class FormController {
	
	// 接收/formName请求，跳转到formName.jsp页面
	@RequestMapping(value = "/{formName}")
	public String formName(@PathVariable String formName) {
		return formName;
	}

}

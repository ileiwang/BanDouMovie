package xyz.leiwang.bandoumovie.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.exception.DIYException;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.UserService;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:40:26
*/
@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	// 显示注册页
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	// 注册时检查用户名
	@RequestMapping("/registerCheckUsername")
	public void registerCheckUsername(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String username) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = userService.findUserByUsername(username);
			if (user!=null) {
				response.getWriter().write("用户名已存在");
			}else{
				response.getWriter().write("可以注册");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 用户注册
	@RequestMapping("/registerUser")
	public String registerUser(Model model, HttpServletRequest request,
			@Validated User user, BindingResult bindingResult,
			@RequestParam String checkImg) throws Exception {
		
		// 出现错误
/*		if (bindingResult.hasErrors()) {
			List<ObjectError> errors =bindingResult.getAllErrors();
			List<String> list = new ArrayList<>();
			for (ObjectError objectError : errors) {
				String str = new String(objectError.getDefaultMessage()
						.getBytes("ISO-8859-1"), "gbk");
				list.add(str);
			}
			model.addAttribute("errors", list);
			return "register";
		}*/
		
		// 验证验证码
		String sessionCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (!sessionCode.equalsIgnoreCase(checkImg)) {
			//throw new DIYException("验证码错误请重新注册");
			//model.addAttribute("message", "验证码错误请重新注册");
			return "redirect:/register.do";
		}
		
		userService.saveUser(user);
		model.addAttribute("message", "注册成功请登录");
		return "msg";
	}

	// 激活用户
	@RequestMapping("/activeUser")
	public String activeUser(@RequestParam String code,Model model) throws DIYException,Exception  {
		/*
		 * 根据传递激活码进行用户查询. 如果用户不为空: 修改用户状态 改为1 如果用户为空: 激活码被篡改了.
		 */
			User activeUser = userService.findByCode(code);
			if(activeUser==null){
				throw new DIYException("激活码被篡改了,请重新注册");
			}
			activeUser.setState(1);
			activeUser.setCode(null);
			userService.activeUser(activeUser);
			model.addAttribute("message", "激活码成功");
			return "msg";
	}

}

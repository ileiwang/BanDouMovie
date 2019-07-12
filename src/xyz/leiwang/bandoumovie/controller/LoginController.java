package xyz.leiwang.bandoumovie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.exception.DIYException;
import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.AdminService;
import xyz.leiwang.bandoumovie.service.UserService;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:40:16
*/
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	// 显示用户登录页
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// 登录时检查用户名
	@RequestMapping("/loginCheckUsername")
	public void loginCheckUsername(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String username) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = userService.findUserByUsername(username);
			if (user!=null) {
				response.getWriter().write("可以登录");
			}else{
				response.getWriter().write("用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 用户登录
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request,
			@RequestParam String checkImg, @ModelAttribute User user, Model model)
			throws DIYException, Exception {
		String sessionCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (!sessionCode.equalsIgnoreCase(checkImg)) {
			request.getSession().setAttribute("message", "验证码输入错误请重新注册");
			 return "redirect:login.do";
		}
		User userLogin = userService.userLogin(user.getUsername(),
				user.getPassword());
		if (userLogin == null) {
			 request.getSession().setAttribute("message", "密码输入错误请重新登陆");
			 return "redirect:login.do";
		}
		request.getSession().setAttribute("userLogin", userLogin);
		request.getSession().removeAttribute("message");
		return "redirect:index.do";
	}

	// 用户退出
	@RequestMapping("/userLogout")
	public String userLogout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		request.getSession().removeAttribute("loginUser");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/BanDouMovie/index.do");
		model.addAttribute("message", "退出成功，系统将在5秒之后跳转到首页");
		return "msg";
	}

	// 显示管理员登录页
	@RequestMapping("/admin/login")
	public String showlogin(){
		return "admin/login";
	}
	
    //管理员登录
	@RequestMapping("/admin/adminLogin")
	public String adminLogin(HttpServletRequest request,Model model,@RequestParam String username,@RequestParam String password) throws Exception{
		Admin adminLogin = adminService.adminLogin(username,password);
		if(adminLogin == null){
			model.addAttribute("message", "管理员用户名或密码错误");
			return "admin/login";
		}
		request.getSession().setAttribute("adminLogin", adminLogin);
		return "admin/index";
	}
	
    //管理员退出
	@RequestMapping("/admin/adminLogout")
	public String adminLogout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		request.getSession().removeAttribute("adminLogin");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/BanDouMovie/index.do");
		model.addAttribute("message", "退出成功，系统将在5秒之后跳转到首页");
		return "msg";
	}

}

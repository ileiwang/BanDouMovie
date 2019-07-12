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

	// ��ʾ�û���¼ҳ
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// ��¼ʱ����û���
	@RequestMapping("/loginCheckUsername")
	public void loginCheckUsername(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String username) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = userService.findUserByUsername(username);
			if (user!=null) {
				response.getWriter().write("���Ե�¼");
			}else{
				response.getWriter().write("�û�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �û���¼
	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request,
			@RequestParam String checkImg, @ModelAttribute User user, Model model)
			throws DIYException, Exception {
		String sessionCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (!sessionCode.equalsIgnoreCase(checkImg)) {
			request.getSession().setAttribute("message", "��֤���������������ע��");
			 return "redirect:login.do";
		}
		User userLogin = userService.userLogin(user.getUsername(),
				user.getPassword());
		if (userLogin == null) {
			 request.getSession().setAttribute("message", "����������������µ�½");
			 return "redirect:login.do";
		}
		request.getSession().setAttribute("userLogin", userLogin);
		request.getSession().removeAttribute("message");
		return "redirect:index.do";
	}

	// �û��˳�
	@RequestMapping("/userLogout")
	public String userLogout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		request.getSession().removeAttribute("loginUser");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/BanDouMovie/index.do");
		model.addAttribute("message", "�˳��ɹ���ϵͳ����5��֮����ת����ҳ");
		return "msg";
	}

	// ��ʾ����Ա��¼ҳ
	@RequestMapping("/admin/login")
	public String showlogin(){
		return "admin/login";
	}
	
    //����Ա��¼
	@RequestMapping("/admin/adminLogin")
	public String adminLogin(HttpServletRequest request,Model model,@RequestParam String username,@RequestParam String password) throws Exception{
		Admin adminLogin = adminService.adminLogin(username,password);
		if(adminLogin == null){
			model.addAttribute("message", "����Ա�û������������");
			return "admin/login";
		}
		request.getSession().setAttribute("adminLogin", adminLogin);
		return "admin/index";
	}
	
    //����Ա�˳�
	@RequestMapping("/admin/adminLogout")
	public String adminLogout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		request.getSession().removeAttribute("adminLogin");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/BanDouMovie/index.do");
		model.addAttribute("message", "�˳��ɹ���ϵͳ����5��֮����ת����ҳ");
		return "msg";
	}

}

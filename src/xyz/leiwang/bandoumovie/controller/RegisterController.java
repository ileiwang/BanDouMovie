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

	// ��ʾע��ҳ
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	// ע��ʱ����û���
	@RequestMapping("/registerCheckUsername")
	public void registerCheckUsername(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String username) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = userService.findUserByUsername(username);
			if (user!=null) {
				response.getWriter().write("�û����Ѵ���");
			}else{
				response.getWriter().write("����ע��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �û�ע��
	@RequestMapping("/registerUser")
	public String registerUser(Model model, HttpServletRequest request,
			@Validated User user, BindingResult bindingResult,
			@RequestParam String checkImg) throws Exception {
		
		// ���ִ���
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
		
		// ��֤��֤��
		String sessionCode = (String) request.getSession().getAttribute(
				"checkcode");
		if (!sessionCode.equalsIgnoreCase(checkImg)) {
			//throw new DIYException("��֤�����������ע��");
			//model.addAttribute("message", "��֤�����������ע��");
			return "redirect:/register.do";
		}
		
		userService.saveUser(user);
		model.addAttribute("message", "ע��ɹ����¼");
		return "msg";
	}

	// �����û�
	@RequestMapping("/activeUser")
	public String activeUser(@RequestParam String code,Model model) throws DIYException,Exception  {
		/*
		 * ���ݴ��ݼ���������û���ѯ. ����û���Ϊ��: �޸��û�״̬ ��Ϊ1 ����û�Ϊ��: �����뱻�۸���.
		 */
			User activeUser = userService.findByCode(code);
			if(activeUser==null){
				throw new DIYException("�����뱻�۸���,������ע��");
			}
			activeUser.setState(1);
			activeUser.setCode(null);
			userService.activeUser(activeUser);
			model.addAttribute("message", "������ɹ�");
			return "msg";
	}

}

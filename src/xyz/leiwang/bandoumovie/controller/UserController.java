package xyz.leiwang.bandoumovie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.Groupbuy;
import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.GroupbuyService;
import xyz.leiwang.bandoumovie.service.MovieService;
import xyz.leiwang.bandoumovie.service.RemarkService;
import xyz.leiwang.bandoumovie.service.UserService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:36:48
*/
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	public MovieService movieService;
	@Autowired
	private RemarkService remarkService;
	@Autowired
	private GroupbuyService groupbuyService;
	
	// ��ʾ�û��޸ĸ�����Ϣҳ��
	@RequestMapping("/showEditUser")
	public String showEditUser(Model model,HttpServletRequest request)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("userLogin");
		
		
		// ��user/editUser.jsp����ʾ���������<input>��value��user������
		model.addAttribute("user", user);
		return "user/editUser";
	}
	
	// ��ʾ����Ա�޸ĸ�����Ϣҳ��
	@RequestMapping("/admin/showEditUser")
	public String adminShowEditUser(@RequestParam int uid,Model model,HttpServletRequest request)
			throws Exception {
		
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		User user = userService.findUserByUid(uid);
		
		model.addAttribute("user", user);
		return "user/editUser";
	}

	
	// ���¸�����Ϣ
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute User user,HttpServletRequest request) throws Exception{

		//System.out.print(user.getUname());
		userService.updateUser(user);
		
		return "redirect:/index.do";
	}
	
	// ��ʾ�û�����
	@RequestMapping("/findUserByUid")
	public String findUserByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception{
		
		User user = userService.findUserByUid(uid);
		
		model.addAttribute("user", user);
		return "user/userInfo";
	}
	
	// ��ʾ��������
	@RequestMapping("/userCenter")
	public String userCenter(Model model,HttpServletRequest request) throws Exception{
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		
		List<Remark> remarkList = remarkService.findRemarkByUid(userLogin.getUid());
		
		List<Groupbuy> groupbuyList = groupbuyService.findGroupbuyListByUid(userLogin.getUid());
		
		List<Movie> movieList = movieService.findMovieByUid(userLogin.getUid());
		
		
		// ��user/userCenter.jsp����ʾ�����б��Ź��б���Ӱ�б�
		model.addAttribute("remarkList", remarkList);
		model.addAttribute("groupbuyList", groupbuyList);
		model.addAttribute("movieList", movieList);
		return "user/userCenter";
	}
	
	// ��ѯ�����û�
	@RequestMapping("/admin/findAllUser")
	public String findAllUser(Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
	// �����û����ɾ���û�
	@RequestMapping("/admin/deleteUserByUid")
	public String deleteUserByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		userService.deleteUserByUid(uid);
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
}

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
	
	// 显示用户修改个人信息页面
	@RequestMapping("/showEditUser")
	public String showEditUser(Model model,HttpServletRequest request)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("userLogin");
		
		
		// 在user/editUser.jsp中显示输入表单，表单<input>的value绑定user的属性
		model.addAttribute("user", user);
		return "user/editUser";
	}
	
	// 显示管理员修改个人信息页面
	@RequestMapping("/admin/showEditUser")
	public String adminShowEditUser(@RequestParam int uid,Model model,HttpServletRequest request)
			throws Exception {
		
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		
		User user = userService.findUserByUid(uid);
		
		model.addAttribute("user", user);
		return "user/editUser";
	}

	
	// 更新个人信息
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute User user,HttpServletRequest request) throws Exception{

		//System.out.print(user.getUname());
		userService.updateUser(user);
		
		return "redirect:/index.do";
	}
	
	// 显示用户资料
	@RequestMapping("/findUserByUid")
	public String findUserByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception{
		
		User user = userService.findUserByUid(uid);
		
		model.addAttribute("user", user);
		return "user/userInfo";
	}
	
	// 显示个人中心
	@RequestMapping("/userCenter")
	public String userCenter(Model model,HttpServletRequest request) throws Exception{
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		
		List<Remark> remarkList = remarkService.findRemarkByUid(userLogin.getUid());
		
		List<Groupbuy> groupbuyList = groupbuyService.findGroupbuyListByUid(userLogin.getUid());
		
		List<Movie> movieList = movieService.findMovieByUid(userLogin.getUid());
		
		
		// 在user/userCenter.jsp中显示评论列表、团购列表、电影列表
		model.addAttribute("remarkList", remarkList);
		model.addAttribute("groupbuyList", groupbuyList);
		model.addAttribute("movieList", movieList);
		return "user/userCenter";
	}
	
	// 查询所有用户
	@RequestMapping("/admin/findAllUser")
	public String findAllUser(Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
	// 根据用户编号删除用户
	@RequestMapping("/admin/deleteUserByUid")
	public String deleteUserByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		
		userService.deleteUserByUid(uid);
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
}

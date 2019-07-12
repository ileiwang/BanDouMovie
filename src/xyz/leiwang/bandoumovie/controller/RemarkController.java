package xyz.leiwang.bandoumovie.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.RemarkService;
import xyz.leiwang.bandoumovie.utils.PageBean;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:36:39
*/
@Controller
public class RemarkController {
	
	@Autowired
	private RemarkService remarkService;

	// 保存评论
	@RequestMapping("/saveRemark")
	public String saveRemark(@RequestParam int mid, @RequestParam String content,HttpServletRequest request,Model model) throws Exception {
		
		Remark remark = new Remark();
		 
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("message", "对不起您还没有登录");
			return "msg";
		}
 
		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		remark.setContent(content);
		remark.setRemarkdate(new Date());
		remark.setUid(loginUser.getUid());
		remark.setMid(mid);		
		remarkService.saveRemark(remark);
		request.getSession().setAttribute("remark", remark);
		
		// 保存评论后，跳转到所有评论列表
		return "redirect:/remarkList.do";
	}

	 
	// 按页显示评论
	@RequestMapping("/remarkListByPage")
	public String remarkListByPage(@RequestParam int page, Model model,
			HttpServletRequest request) throws Exception {
		PageBean<Remark> pageBean = remarkService.findRemarkByPage(page);
		
		
		model.addAttribute("pageBean", pageBean);
		return "remark/remarkList";
	} 
	
	// 显示所有评论
	@RequestMapping("/remarkList")
	public String remarkList(Model model,
			HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findAllRemark();
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	// 显示我的评论列表
	@RequestMapping("/myRemarkList")
	public String myRemarkList(Model model,HttpServletRequest request) throws Exception {
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		if(userLogin==null) {
			return "login";
		}
		List<Remark> remarkList = remarkService.findRemarkByUid(userLogin.getUid());
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	// 按用户查询评论列表
	@RequestMapping("/remarkListByUid")
	public String remarkListByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findRemarkByUid(uid);
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	// 显示某电影评论列表
	@RequestMapping("/remarkListByMid")
	public String remarkListByMid(@RequestParam int mid,Model model,HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findRemarkByMid(mid);
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	
	// 根据评论编号删除评论
	@RequestMapping("/admin/deleteRemarkByRid")
	public String deleteRemarkByRid(@RequestParam int rid, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		
		remarkService.deleteRemarkByRid(rid);
		
		return "redirect:/remarkList.do";
	}
	
	// 显示评论更新页面
	@RequestMapping("/admin/editRemark")
	public String editRemark(@RequestParam int rid, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		
		Remark remark = remarkService.findRemarkByPrimaryKey(rid);
		
		model.addAttribute("remark", remark);
		
		return "remark/editRemark";
	}
	
	// 更新评论
	@RequestMapping("/admin/updateRemark")
	public String updateRemark(@ModelAttribute Remark remark, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/login";
		}
		remarkService.updateRemark(remark);
		return "redirect:/remarkList.do";
	}
}

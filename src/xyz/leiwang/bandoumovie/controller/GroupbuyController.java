package xyz.leiwang.bandoumovie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.po.Groupbuy;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.GroupbuyService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-10 00:58:44
*/
@Controller
public class GroupbuyController {
	
	
	@Autowired
	private GroupbuyService groupbuyService;
	
	// 根据用户编号查询团购列表
	@RequestMapping("/findGroupbuyListByUid")
	public String findGroupbuyListByUid(@RequestParam int uid, Model model,
			HttpServletRequest request) throws Exception {
		
		List<Groupbuy> groupbuyList = groupbuyService.findGroupbuyListByUid(uid);
		model.addAttribute("groupbuyList", groupbuyList);
		return "groupbuy/groupbuyList";
	} 
	
	// 根据团购编号查询团购信息
	@RequestMapping("/findGroupbuyByGid")
	public String findGroupbuyByGid(@RequestParam int gid, Model model,
			HttpServletRequest request) throws Exception {
		
		Groupbuy groupbuy = groupbuyService.selectByPrimaryKeyWithMovieAndUserList(gid);
		model.addAttribute("groupbuy", groupbuy);
		return "groupbuy/groupbuyInfo";
	} 
	
	@RequestMapping("/findAllGroupbuy")
	public String findAllGroupbuy(Model model,
			HttpServletRequest request) throws Exception {
		
		List<Groupbuy> groupbuyList = groupbuyService.findAllGroupbuy();
		model.addAttribute("groupbuyList", groupbuyList);
		return "groupbuy/groupbuyList";
	} 
	
	
	// 根据电影编号查询团购列表
	@RequestMapping("/findGroupbuyListByMid")
	public String findGroupbuyListByMid(@RequestParam int mid, Model model,
			HttpServletRequest request) throws Exception {
		
		List<Groupbuy> groupbuyList = groupbuyService.findGroupbuyListByMid(mid);
		
		model.addAttribute("groupbuyList", groupbuyList);
		return "groupbuy/groupbuyList";
	} 
	
	// 已登录用户加入团购
	@RequestMapping("/joinGroupbuy")
	public String joinGroupbuy(@RequestParam int gid, Model model,
			HttpServletRequest request) throws Exception {
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		if(userLogin == null) {
			return "redirect:/login.do";
		}
		groupbuyService.joinGroupbuy(gid, userLogin.getUid());
		
		Groupbuy groupbuy = groupbuyService.selectByPrimaryKeyWithMovieAndUserList(gid);
		model.addAttribute("groupbuy", groupbuy);
		return "groupbuy/groupbuyInfo";
	} 
	
	// 已登录用户创建团购
	@RequestMapping("/createGroupbuy")
	public String createGroupbuy(@RequestParam int mid, Model model,
			HttpServletRequest request) throws Exception {
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		
		if(userLogin == null) {
			return "redirect:/login.do";
		}
		
		groupbuyService.createGroupbuy(mid);
		
		return "redirect:/findMovieByMid.do?mid=${mid}";
	} 
	
}

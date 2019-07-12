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

	// ��������
	@RequestMapping("/saveRemark")
	public String saveRemark(@RequestParam int mid, @RequestParam String content,HttpServletRequest request,Model model) throws Exception {
		
		Remark remark = new Remark();
		 
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("message", "�Բ�������û�е�¼");
			return "msg";
		}
 
		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		remark.setContent(content);
		remark.setRemarkdate(new Date());
		remark.setUid(loginUser.getUid());
		remark.setMid(mid);		
		remarkService.saveRemark(remark);
		request.getSession().setAttribute("remark", remark);
		
		// �������ۺ���ת�����������б�
		return "redirect:/remarkList.do";
	}

	 
	// ��ҳ��ʾ����
	@RequestMapping("/remarkListByPage")
	public String remarkListByPage(@RequestParam int page, Model model,
			HttpServletRequest request) throws Exception {
		PageBean<Remark> pageBean = remarkService.findRemarkByPage(page);
		
		
		model.addAttribute("pageBean", pageBean);
		return "remark/remarkList";
	} 
	
	// ��ʾ��������
	@RequestMapping("/remarkList")
	public String remarkList(Model model,
			HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findAllRemark();
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	// ��ʾ�ҵ������б�
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
	
	// ���û���ѯ�����б�
	@RequestMapping("/remarkListByUid")
	public String remarkListByUid(@RequestParam int uid,Model model,HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findRemarkByUid(uid);
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	// ��ʾĳ��Ӱ�����б�
	@RequestMapping("/remarkListByMid")
	public String remarkListByMid(@RequestParam int mid,Model model,HttpServletRequest request) throws Exception {
		
		List<Remark> remarkList = remarkService.findRemarkByMid(mid);
		
		
		model.addAttribute("remarkList", remarkList);
		return "remark/remarkList";
	} 
	
	
	
	// �������۱��ɾ������
	@RequestMapping("/admin/deleteRemarkByRid")
	public String deleteRemarkByRid(@RequestParam int rid, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		remarkService.deleteRemarkByRid(rid);
		
		return "redirect:/remarkList.do";
	}
	
	// ��ʾ���۸���ҳ��
	@RequestMapping("/admin/editRemark")
	public String editRemark(@RequestParam int rid, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		Remark remark = remarkService.findRemarkByPrimaryKey(rid);
		
		model.addAttribute("remark", remark);
		
		return "remark/editRemark";
	}
	
	// ��������
	@RequestMapping("/admin/updateRemark")
	public String updateRemark(@ModelAttribute Remark remark, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		remarkService.updateRemark(remark);
		return "redirect:/remarkList.do";
	}
}

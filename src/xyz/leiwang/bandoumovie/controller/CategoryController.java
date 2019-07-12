package xyz.leiwang.bandoumovie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.service.CategoryService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:36:21
*/
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	//�������Ų�ѯ����
	@RequestMapping("/findCategoryByCid")
	public String findMovieByMid(@RequestParam int cid,Model model) throws Exception {
			Category category = categoryService.findCategoryByCid(cid);
			model.addAttribute("category", category);
		return "category/categoryInfo";
	}
	
	
	// ��ѯȫ������
	@RequestMapping("/findAllCategory")
	public String findAllCategory(Model model, HttpServletRequest request)
			throws Exception {

		List<Category> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "category/categoryList";
	}

	// ��ʾ��ӷ���ҳ��
	@RequestMapping("/admin/addCategory")
	public String addCategory(Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
//		List<Category> categoryList = categoryService.adminbFindCategory();
//		model.addAttribute("categoryList", categoryList);
		return "category/addCategory";
	}
	
	
	// �������
	@RequestMapping("/admin/saveCategory")
	public String saveCategory(@RequestParam String cname,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		Category addCategory = new Category();
		addCategory.setCname(cname);
		categoryService.addCategory(addCategory);
		return "redirect:/admin/findAllCategory.do";
	}

	
	// ��ʾ���·���ҳ��
	@RequestMapping("/admin/editCategory")
	public String editCategory(@RequestParam int cid, Model model,HttpServletRequest request)
			throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		Category category = categoryService.findCategoryByCid(cid);
		model.addAttribute("category", category);
		return "category/editCategory";
	}

	// ���·���
	@RequestMapping("/admin/updateCategory")
	public String updateCategory(@RequestParam int cid,
			@RequestParam String cname,HttpServletRequest request) {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		categoryService.updateCategory(category);
		return "redirect:/admin/findAllCategory.do";
	}

	// ��������ɾ������
	@RequestMapping("/admin/deleteCategory")
	public String deleteCategory(@RequestParam int cid,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		categoryService.deleteCategoryByCid(cid);
		return "redirect:/findAllCategory.do";
	}

}

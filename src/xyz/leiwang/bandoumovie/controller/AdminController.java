package xyz.leiwang.bandoumovie.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.service.AdminService;
import xyz.leiwang.bandoumovie.service.CategoryService;
import xyz.leiwang.bandoumovie.service.GroupbuyService;
import xyz.leiwang.bandoumovie.service.MovieService;
import xyz.leiwang.bandoumovie.service.RemarkService;
import xyz.leiwang.bandoumovie.service.UserService;
import xyz.leiwang.bandoumovie.utils.PageBean;
import xyz.leiwang.bandoumovie.utils.UUIDUtils;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:35:44
*/
@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public MovieService movieService;
	@Autowired
	private RemarkService remarkService;
	
	@Autowired
	private GroupbuyService groupbuyService;
	
	@Autowired
	private AdminService adminService;

}

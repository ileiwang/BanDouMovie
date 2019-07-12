package xyz.leiwang.bandoumovie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.po.Groupbuy;
import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.service.CategoryService;
import xyz.leiwang.bandoumovie.service.GroupbuyService;
import xyz.leiwang.bandoumovie.service.MovieService;
import xyz.leiwang.bandoumovie.service.RemarkService;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:41:00
*/
@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private RemarkService remarkService;
	@Autowired
	private GroupbuyService groupbuyService;
	
	// 进入到主页
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request) throws Exception {
			
			List<Category> categoryList = categoryService.findAllCategoryWithMovieList();
/*			request.getSession().getServletContext().setAttribute("categoryList",categoryList);*/
			
//			List<Movie> newMovieList = movieService.findNewMovie();
//			model.addAttribute("newMovieList", newMovieList);
			
			List<Movie> movieList = movieService.findAllMovie();
			
			List<Remark> remarkList = remarkService.findAllRemark();
			
			List<Groupbuy> groupbuyList = groupbuyService.findAllGroupbuy();
			
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("movieList", movieList);
			model.addAttribute("remarkList", remarkList);
			model.addAttribute("groupbuyList", groupbuyList);
		return "index";
	}
	
	@RequestMapping("/admin/index")
	public String adminIndex(Model model,HttpServletRequest request) throws Exception {
		return "admin/index";
	}
	
	// 关于
	@RequestMapping("/about")
	public String about(Model model,HttpServletRequest request) throws Exception {
		return "about";
	}
	

	// 按照condition搜索电影
	@RequestMapping("/searchMovie")
	public String searchMovie(@RequestParam String condition,Model model,HttpServletRequest request) throws Exception {
		
//			List<Category> allMovieList = categoryService.findAllCategoryWithMovieList();
//			request.getSession().getServletContext().setAttribute("allMovieList",allMovieList); 
//			
//			//最新电影列表
//		    List<Movie> newMovieList= movieService.findNewMovie();
//			model.addAttribute("newMovieList", newMovieList);
		
			List<Movie> movieList = movieService.searchMovie(condition);
			
			model.addAttribute("movieList", movieList);
			
		return "movie/movieList";
	}

}

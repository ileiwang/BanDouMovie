package xyz.leiwang.bandoumovie.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.po.Groupbuy;
import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.po.User;
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
* @date 2019-07-09 10:36:06
*/
@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	public CategoryService categoryService;

	@Autowired
	private RemarkService remarkService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupbuyService groupbuyService;
	
	//����Ӱ��Ų�ѯ��Ӱ
	@RequestMapping("/findMovieByMid")
	public String findMovieByMid(@RequestParam int mid,Model model,HttpServletRequest request) throws Exception {
			
			Movie movie = movieService.findMovieByMid(mid);
			
			// �����õ�Ӱ���û�
			List<User> userList = userService.findUserByMid(mid);
			
			// �õ�Ӱ������
			List<Remark> remarkList = remarkService.findRemarkByMid(mid);
			
			List<Groupbuy> groupbuyList  = groupbuyService.findGroupbuyListByMid(mid);
			
			
			if (movie==null) {
				model.addAttribute("movieflag", 0);
			}
			else {
				model.addAttribute("movie", movie);
			}
			
			if (userList==null) {
				model.addAttribute("userflag", 0);
			}
			else {
				model.addAttribute("userList", userList);
			}
			
			if (remarkList==null) {
				model.addAttribute("remarkflag", 0);
			}
			else {
				model.addAttribute("remarkList", remarkList);
			}
			
			if (groupbuyList==null) {
				model.addAttribute("groupbuyflag", 0);
			}
			else {
				model.addAttribute("groupbuyList", groupbuyList);
			}
			
		return "movie/movieInfo";
	}
	
	
	// ���û���ѯ��Ӱ
	@RequestMapping("/findMovieByUid")
	public String findMovieByUid(@RequestParam int uid, Model model,HttpServletRequest request)
			throws Exception {
		
		List<Movie> movieList = movieService.findMovieByUid(uid);
		model.addAttribute("movieList", movieList);
		return "movie/movieList";
	}
	
	// ��ҳ��ѯ��Ӱ
	@RequestMapping("/findMovieByPage")
	public String findMovieByPage(@RequestParam int page, Model model,HttpServletRequest request)
			throws Exception {
		
		PageBean<Movie> movieList = movieService.findMovieByPage(page);
		model.addAttribute("movieList", movieList);
		return "movie/movieList";
	}
	
	// ��ѯ���е�Ӱ
	@RequestMapping("/findAllMovie")
	public String findAllMovie(Model model,HttpServletRequest request)
			throws Exception {
		
		List<Movie> movieList = movieService.findAllMovie();
		model.addAttribute("movieList", movieList);
		return "movie/movieList";
	}

	// ��ʾ��ӵ�Ӱҳ��
	@RequestMapping("/admin/showAddMovie")
	public String showAddMovie(Model model,HttpServletRequest request) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}

		List<Category> categoryList = categoryService.findAllCategory();

		model.addAttribute("categoryList", categoryList);
		return "movie/addMovie";
	}

	// �����Ӱ
	@RequestMapping("/admin/saveMovie")
	public String saveMovie(@ModelAttribute Movie movie,HttpServletRequest request,MultipartFile file) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		movie.setDate(new Date());
		
		if (file != null) {
			String path = request.getServletContext().getRealPath(
					"/images");
			String uploadFileName = file.getOriginalFilename();
			String fileName = UUIDUtils.getUUID()+uploadFileName;
			File diskFile = new File(path + "//" + fileName);
			file.transferTo(diskFile);
			movie.setImage(fileName);
		}
		
		movieService.saveMovie(movie);
		return "redirect:/findAllMovie.do";
	}
	
	// ����Ӱ���ɾ����Ӱ
	@RequestMapping("/admin/deleteMovieByMid")
	public String deleteMovieByMid(@RequestParam int mid,HttpServletRequest request) throws Exception{
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		movieService.deleteMovieByMid(mid);
		return "redirect:/findAllMovie.do";
	}

	// ��ʾ�޸ĵ�Ӱҳ��
	@RequestMapping("/admin/showEditMovie")
	public String showEditMovie(@RequestParam int mid,Model model,HttpServletRequest request) throws Exception{
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		
		Movie movie = movieService.findMovieByMid(mid);
		model.addAttribute("movie", movie);
		
		List<Category> categoryList = categoryService.findCategoryByExample();
		model.addAttribute("categoryList", categoryList);
		return "movie/editMovie";
	}
	
	// �޸ĵ�Ӱ
	@RequestMapping("/admin/updateMovie")
	public String updateMovie(@ModelAttribute Movie movie,HttpServletRequest request,MultipartFile file) throws Exception {
		Admin adminLogin = (Admin) request.getSession().getAttribute("adminLogin");
		if(adminLogin==null){
			request.getSession().setAttribute("message","�Բ�������û�е�¼");
			return "admin/login";
		}
		movie.setDate(new Date());

		if (file != null) {
			String path = request.getServletContext().getRealPath(
					"/images");
			String uploadFileName = file.getOriginalFilename();
			String fileName = UUIDUtils.getUUID()+uploadFileName;
			File diskFile = new File(path + "//" + fileName);
			file.transferTo(diskFile);
			movie.setImage(fileName);
		}
		 
		movieService.updateMovie(movie);
		return "redirect:/findMovieByMid.do?mid=${movie.mid}";
	}
	
	// �����û������õ�Ӱ
	@RequestMapping("/watchedMovie")
	public String watchedMovie(@RequestParam int mid,Model model,HttpServletRequest request)
			throws Exception {
		
		User userLogin = (User) request.getSession().getAttribute("userLogin");
		
		if(userLogin == null) {
			return "redirect:/login.do";
		}
		
		movieService.saveWatchedMovie(userLogin.getUid(), mid);
		
		return "redirect:/findMovieByMid.do?mid=${mid}";
	}
}

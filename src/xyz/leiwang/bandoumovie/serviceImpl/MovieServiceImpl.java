package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xyz.leiwang.bandoumovie.mapper.MovieMapper;
import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.MovieExample;
import xyz.leiwang.bandoumovie.service.MovieService;
import xyz.leiwang.bandoumovie.utils.PageBean;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:52:26
*/
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieMapper movieMapper;

//	public List<Movie> findHotMovie() throws Exception {
//		 MovieExample example = new MovieExample();
//		 MovieExample.Criteria criteria = example.createCriteria();
//		 criteria.andIsHotEqualTo(1);
//		 example.setOrderByClause("date DESC");
//		 example.setBeginPage(0);
//		 example.setEnd(4);		 
//		 List<Movie> list = movieMapper.selectByExample(example);
//		 
//		 if(list!=null && list.size()>0){
//			 return list;
//		 }
//		 return null;
//	}
	
	@Override
	public List<Movie> findNewMovie() throws Exception {
		 MovieExample example = new MovieExample();
		 example.setOrderByClause("date DESC");
		 example.setBeginPage(0);
		 example.setEnd(8);		 
		 List<Movie> list = movieMapper.selectByExample(example);

		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	@Override
	public List<Movie> findAllMovie() throws Exception {
		
		 MovieExample example = new MovieExample();	 
		 List<Movie> list = movieMapper.selectByExample(example);
		 System.out.println(list);
		 
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	@Override
	public List<Movie> searchMovie(String condition) throws Exception {
		 	 
		 List<Movie> list = movieMapper.searchMovie(condition) ;
		  
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	
	public List<Movie> findMovieByUid(Integer uid) throws Exception{
		
		 List<Movie> list = movieMapper.findMovieByUid(uid);
		  
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	public Movie findMovieByMid(Integer mid) throws Exception {
		return movieMapper.selectByPrimaryKey(mid);
	}
	
	public PageBean<Movie> findMovieByCidAndPage(int cid, int page)
			throws Exception {
		PageBean<Movie> pageBean = new PageBean<>();
//		设置第几页
		pageBean.setPage(page);
//		设置每页显示个数
		int limitPage = 12;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
		
		totlePage = movieMapper.countMovieByCid(cid);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;

		List<Movie> list = movieMapper.findMovieByCidAndPageAndLimit(cid,beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	@Override
	public PageBean<Movie> findMovieByPage(int page) throws Exception {
		PageBean<Movie> pageBean = new PageBean<>();
		pageBean.setPage(page);
//		设置10个
		int limitPage =12;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		MovieExample example = new MovieExample();
		totlePage = movieMapper.countByExample(example);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;

		List<Movie> list = movieMapper.findMovieByPageAndLimit(beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public void saveMovie(Movie movie) throws Exception {
		movieMapper.insert(movie);
	}
	
	@Override
	public void deleteMovieByMid(int mid) throws Exception {
		movieMapper.deleteByPrimaryKey(mid);
	}
	
	@Override
	public void updateMovie(Movie movie) throws Exception {
		movieMapper.updateByPrimaryKey(movie);
	}
	
	@Override
	public void saveWatchedMovie(Integer uid,Integer mid) throws Exception{
		movieMapper.saveWatchedMovie(uid, mid);
	}

}

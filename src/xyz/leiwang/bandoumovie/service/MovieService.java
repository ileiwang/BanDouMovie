package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.utils.PageBean;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:50:16
*/
public interface MovieService {

//		public List<Movie> findHotMovie() throws Exception;

		public List<Movie> findNewMovie() throws Exception;

		public List<Movie> findAllMovie() throws Exception;
		
		public List<Movie> searchMovie(String condition) throws Exception;
		
		public List<Movie> findMovieByUid(Integer uid) throws Exception;

		public Movie findMovieByMid(Integer mid) throws Exception;

		public PageBean<Movie> findMovieByCidAndPage(int cid,int page) throws Exception;

		public PageBean<Movie> findMovieByPage(int page) throws Exception;

		public void saveMovie(Movie movie) throws Exception;

		public void deleteMovieByMid(int mid) throws Exception;

		public void updateMovie(Movie movie) throws Exception;
		
		public void saveWatchedMovie(Integer uid,Integer mid) throws Exception;
		
		
}

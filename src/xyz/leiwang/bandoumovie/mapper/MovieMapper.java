package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.leiwang.bandoumovie.po.Movie;
import xyz.leiwang.bandoumovie.po.MovieExample;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:53:59
*/
public interface MovieMapper {
	
	int countMovieByCid(Integer cid);
	
    int countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
    
    // 根据分类和页数和每页数量查询
	List<Movie> findMovieByCidAndPageAndLimit(int cid,int page,int limit);

	// 根据页数和每页数量查询
	List<Movie> findMovieByPageAndLimit(int page, int limit);
	
	List<Movie> searchMovie(String condition);
	
	// 查询用户看过的电影
	List<Movie> findMovieByUid(Integer uid);
	
	//用户看过该电影
	
	int saveWatchedMovie(Integer uid,Integer mid);

}

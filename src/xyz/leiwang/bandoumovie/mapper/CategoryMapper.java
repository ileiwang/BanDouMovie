package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.po.CategoryExample;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:53:50
*/
public interface CategoryMapper {
	
	int countByExample(CategoryExample example);

	int deleteByExample(CategoryExample example);

	int deleteByPrimaryKey(Integer cid);

	int insert(Category record);

	int insertSelective(Category record);
	
	List<Category> findAllCategoryWithMovieList();
	
	List<Category> findAllCategory();

	List<Category> selectByExample(CategoryExample example);

	Category selectByPrimaryKey(Integer cid);

	int updateByExampleSelective(@Param("record") Category record,
			@Param("example") CategoryExample example);

	int updateByExample(@Param("record") Category record,
			@Param("example") CategoryExample example);

	int updateByPrimaryKeySelective(Category record);

	int updateByPrimaryKey(Category record);

}

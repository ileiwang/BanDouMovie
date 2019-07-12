package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Category;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:50:38
*/
public interface CategoryService {
	
	public List<Category> findAllCategoryWithMovieList() throws Exception;
	
	public List<Category> findAllCategory() throws Exception;
	
//	增加分类
	public void addCategory(Category addCategory) throws Exception;
	
	public List<Category> findCategoryByExample() throws Exception;
	
//	根据cid查询分类
	public Category findCategoryByCid(int cid) throws Exception;
	
//	更新分类
	public void updateCategory(Category category);
	
//	根据cid删除分类
	public void deleteCategoryByCid(int cid) throws Exception;

}

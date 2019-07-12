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
	
//	���ӷ���
	public void addCategory(Category addCategory) throws Exception;
	
	public List<Category> findCategoryByExample() throws Exception;
	
//	����cid��ѯ����
	public Category findCategoryByCid(int cid) throws Exception;
	
//	���·���
	public void updateCategory(Category category);
	
//	����cidɾ������
	public void deleteCategoryByCid(int cid) throws Exception;

}

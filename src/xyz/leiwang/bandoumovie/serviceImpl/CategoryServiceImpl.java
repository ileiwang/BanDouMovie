package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import xyz.leiwang.bandoumovie.mapper.CategoryMapper;
import xyz.leiwang.bandoumovie.po.Category;
import xyz.leiwang.bandoumovie.po.CategoryExample;
import xyz.leiwang.bandoumovie.service.CategoryService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:52:19
*/
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	//查询所有分类，级联查询每个分类的所有电影
	@Override
	public List<Category> findAllCategoryWithMovieList() throws Exception {
		List<Category> list = categoryMapper.findAllCategoryWithMovieList();
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//查询所有分类，不级联查询每个分类的所有电影
	@Override
	public List<Category> findAllCategory() throws Exception {
		List<Category> list = categoryMapper.findAllCategory();
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	//按条件查询分类
	@Override
	public List<Category> findCategoryByExample() {
		
		CategoryExample example = new CategoryExample();
		
		List<Category> list = categoryMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	@Override
	public void addCategory(Category category) throws Exception {
		categoryMapper.insert(category);
	}
	
	@Override
	public Category findCategoryByCid(int cid) throws Exception {
		return categoryMapper.selectByPrimaryKey(cid);
	}
	
	@Override
	public void updateCategory(Category category) {
		categoryMapper.updateByPrimaryKey(category);
	}
	
	@Override
	public void deleteCategoryByCid(int cid) throws Exception {
		categoryMapper.deleteByPrimaryKey(cid);
	}
}
	

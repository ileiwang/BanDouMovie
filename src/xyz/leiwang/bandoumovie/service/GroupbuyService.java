package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Groupbuy;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 23:30:17
*/
public interface GroupbuyService {
	
	// 根据用户ID查询团购列表
	public List<Groupbuy> findGroupbuyListByUid(Integer uid);
	
	public List<Groupbuy> findGroupbuyListByMid(Integer mid);
	
	public List<Groupbuy> findAllGroupbuy();
	
	public void deleteByPrimaryKey(Integer gid);
	
	public void insert(Groupbuy groupbuy);
	
	public void insertSelective(Groupbuy groupbuy);
	
	// 加载基本信息
	public Groupbuy selectByPrimaryKey(Integer gid);
	
	// 加载全部信息
	public Groupbuy selectByPrimaryKeyWithMovieAndUserList(Integer gid);
	
	// 用户加入团购
	public void joinGroupbuy(Integer gid,Integer uid);
	
	// 用户创建团购
	public void createGroupbuy(Integer mid);
	
	

}

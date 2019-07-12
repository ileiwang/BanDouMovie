package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Groupbuy;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 22:51:15
*/
public interface GroupbuyMapper {
	
	
	// 查询用户参加过的团购
	List<Groupbuy> findGroupbuyListByUid(Integer uid);
	
	// 查询某电影所有团购信息
	List<Groupbuy> findGroupbuyListByMid(Integer mid);
	
	// 查询所有团购信息
	List<Groupbuy> findAllGroupbuy();
	
	int deleteByPrimaryKey(Integer gid);
	
	int insert(Groupbuy groupbuy);
	
	int insertSelective(Groupbuy groupbuy);
	
	// 加载基本信息
	Groupbuy selectByPrimaryKey(Integer gid);
	
	// 加载全部信息
	Groupbuy selectByPrimaryKeyWithMovieAndUserList(Integer gid);
	
	//加入用户团购
	void insertItem(Integer gid,Integer uid);
}

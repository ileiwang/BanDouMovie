package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.po.UserExample;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:49:59
*/
public interface UserService {
	
	public User findUserByUsername(String username) throws Exception;

	public User findUserByUid(int uid) throws Exception;
	
	public void saveUser(User user) throws Exception;
	
	public User findByCode(String code)throws Exception;
	
	public void activeUser(User activeUser)throws Exception;

	public User userLogin(String username, String password) throws Exception;
	
	public List<User> findAllUser() throws Exception;
	
	public void deleteUserByUid(int uid) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	// 查询某团购所有参与用户
	public List<User> findUserListByGid(Integer gid) throws Exception;
	
	public int countByExample(UserExample example) throws Exception;
	
	public void deleteByExample(UserExample example) throws Exception;
	
	public List<User> selectByExample(UserExample example) throws Exception;
	
	public List<User> findUserByMid(Integer mid) throws Exception;
	
}

package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xyz.leiwang.bandoumovie.mapper.UserMapper;
import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.po.UserExample;
import xyz.leiwang.bandoumovie.service.UserService;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:52:39
*/
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByUsername(String username) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}
	
	@Override	
	public User findUserByUid(int uid) throws Exception{
		return userMapper.selectByPrimaryKey(uid);
	}

//	@Override
//	public void saveUser(User user) throws Exception {
//		user.setState(0);
//		user.setCode(UUIDUtils.getUUID());
//		int i = userMapper.insert(user);
//		System.out.println(i);
//		String emailMsg = "请激活<a href='http://localhost:8080/shop/activeUser.action?code="
//				+ user.getCode() + "'>激活</a>激活码是： + user.getCode()";
//		try {
//			MailUtils.sendMail(user.getEmail(), emailMsg);
//		} catch (Exception e) {
//		} 
//	}
	
	@Override
	public void saveUser(User user) throws Exception {
		user.setState(1);
//		user.setCode(UUIDUtils.getUUID());
		userMapper.insert(user);
	}

	@Override
	public User findByCode(String code) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}

/*	激活用户*/
	@Override
	public void activeUser(User user) throws Exception {
		userMapper.updateByPrimaryKeySelective(user);
	}

/*	用户登录*/
	@Override
	public User userLogin(String username, String password)
			throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}
	
/*	查询所有用户*/
	@Override
	public List<User> findAllUser() throws Exception {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}
	
	public void deleteUserByUid(int uid) throws Exception{
		userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public void updateUser(User user) throws Exception{
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	// 查询某团购所有参与用户
	@Override
	public List<User> findUserListByGid(Integer gid) throws Exception{
		 List<User> list = userMapper.findUserListByGid(gid);
		 
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	@Override
	public int countByExample(UserExample example) throws Exception{
		
		return userMapper.countByExample(example);
		
	}
	
	@Override
	public void deleteByExample(UserExample example) throws Exception{
		userMapper.deleteByExample(example);
		
	}
	
	@Override
	public List<User> selectByExample(UserExample example) throws Exception{
		 List<User> list = userMapper.selectByExample(example);
		 
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}
	
	@Override
	public List<User> findUserByMid(Integer mid) throws Exception{
		
		 List<User> list = userMapper.selectByMid(mid);
		 
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

}

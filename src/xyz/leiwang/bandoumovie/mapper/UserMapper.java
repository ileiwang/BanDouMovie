package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.leiwang.bandoumovie.po.User;
import xyz.leiwang.bandoumovie.po.UserExample;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:54:17
*/
public interface UserMapper {
	
	// 根据团购ID查询用户列表
	List<User> findUserListByGid(Integer gid);
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    
    List<User> selectByMid(Integer mid);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
	

}

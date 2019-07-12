package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.AdminExample;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:53:39
*/
public interface AdminMapper {
	
	// 按条件统计数量
    int countByExample(AdminExample example);

    // 按条件删除
    int deleteByExample(AdminExample example);

    // 按主键删除
    int deleteByPrimaryKey(Integer aid);

    // 插入全部列
    int insert(Admin admin);

    // 插入部分列
    int insertSelective(Admin admin);

    // 按条件选择
    List<Admin> selectByExample(AdminExample example);

    // 按主键选择
    Admin selectByPrimaryKey(Integer aid);

    // 按条件更新部分列
    int updateByExampleSelective(@Param("record") Admin admin, @Param("example") AdminExample example);

    // 按条件更新全部列
    int updateByExample(@Param("record") Admin admin, @Param("example") AdminExample example);

    // 按主键更新部分列
    int updateByPrimaryKeySelective(Admin admin);

    // 按主键更新全部列
    int updateByPrimaryKey(Admin admin);

}

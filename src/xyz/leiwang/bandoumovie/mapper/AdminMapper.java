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
	
	// ������ͳ������
    int countByExample(AdminExample example);

    // ������ɾ��
    int deleteByExample(AdminExample example);

    // ������ɾ��
    int deleteByPrimaryKey(Integer aid);

    // ����ȫ����
    int insert(Admin admin);

    // ���벿����
    int insertSelective(Admin admin);

    // ������ѡ��
    List<Admin> selectByExample(AdminExample example);

    // ������ѡ��
    Admin selectByPrimaryKey(Integer aid);

    // ���������²�����
    int updateByExampleSelective(@Param("record") Admin admin, @Param("example") AdminExample example);

    // ����������ȫ����
    int updateByExample(@Param("record") Admin admin, @Param("example") AdminExample example);

    // ���������²�����
    int updateByPrimaryKeySelective(Admin admin);

    // ����������ȫ����
    int updateByPrimaryKey(Admin admin);

}

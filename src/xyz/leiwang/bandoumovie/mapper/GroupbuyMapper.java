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
	
	
	// ��ѯ�û��μӹ����Ź�
	List<Groupbuy> findGroupbuyListByUid(Integer uid);
	
	// ��ѯĳ��Ӱ�����Ź���Ϣ
	List<Groupbuy> findGroupbuyListByMid(Integer mid);
	
	// ��ѯ�����Ź���Ϣ
	List<Groupbuy> findAllGroupbuy();
	
	int deleteByPrimaryKey(Integer gid);
	
	int insert(Groupbuy groupbuy);
	
	int insertSelective(Groupbuy groupbuy);
	
	// ���ػ�����Ϣ
	Groupbuy selectByPrimaryKey(Integer gid);
	
	// ����ȫ����Ϣ
	Groupbuy selectByPrimaryKeyWithMovieAndUserList(Integer gid);
	
	//�����û��Ź�
	void insertItem(Integer gid,Integer uid);
}

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
	
	// �����û�ID��ѯ�Ź��б�
	public List<Groupbuy> findGroupbuyListByUid(Integer uid);
	
	public List<Groupbuy> findGroupbuyListByMid(Integer mid);
	
	public List<Groupbuy> findAllGroupbuy();
	
	public void deleteByPrimaryKey(Integer gid);
	
	public void insert(Groupbuy groupbuy);
	
	public void insertSelective(Groupbuy groupbuy);
	
	// ���ػ�����Ϣ
	public Groupbuy selectByPrimaryKey(Integer gid);
	
	// ����ȫ����Ϣ
	public Groupbuy selectByPrimaryKeyWithMovieAndUserList(Integer gid);
	
	// �û������Ź�
	public void joinGroupbuy(Integer gid,Integer uid);
	
	// �û������Ź�
	public void createGroupbuy(Integer mid);
	
	

}

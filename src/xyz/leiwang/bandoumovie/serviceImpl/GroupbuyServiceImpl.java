package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xyz.leiwang.bandoumovie.mapper.GroupbuyMapper;
import xyz.leiwang.bandoumovie.po.Groupbuy;
import xyz.leiwang.bandoumovie.service.GroupbuyService;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-10 00:52:39
*/
public class GroupbuyServiceImpl implements GroupbuyService{
	
	@Autowired
	private GroupbuyMapper groupbuyMapper;
	
	// �����û�ID��ѯ�Ź��б�
	@Override
	public List<Groupbuy> findGroupbuyListByUid(Integer uid){
		return groupbuyMapper.findGroupbuyListByUid(uid);
	}
	
	@Override
	public List<Groupbuy> findGroupbuyListByMid(Integer mid){
		return groupbuyMapper.findGroupbuyListByMid(mid);
	}
	
	@Override
	public List<Groupbuy> findAllGroupbuy(){
		return groupbuyMapper.findAllGroupbuy();
	}
	@Override
	public void deleteByPrimaryKey(Integer gid) {
		groupbuyMapper.deleteByPrimaryKey(gid);
	}
	
	@Override
	public void insert(Groupbuy groupbuy) {
		groupbuyMapper.insert(groupbuy);
	}
	
	@Override
	public void insertSelective(Groupbuy groupbuy) {
		groupbuyMapper.insertSelective(groupbuy);
	}
	
	// ���ػ�����Ϣ
	@Override
	public Groupbuy selectByPrimaryKey(Integer gid) {
		return groupbuyMapper.selectByPrimaryKey(gid);
	}
	
	// ����ȫ����Ϣ
	@Override
	public Groupbuy selectByPrimaryKeyWithMovieAndUserList(Integer gid) {
		return groupbuyMapper.selectByPrimaryKeyWithMovieAndUserList(gid);
	}
	
	// �û������Ź�
	@Override
	public void joinGroupbuy(Integer gid,Integer uid) {
		groupbuyMapper.insertItem(gid,uid);
	}
	
	//�û������Ź�
	@Override
	public void createGroupbuy(Integer mid) {
		Groupbuy groupbuy = new Groupbuy();
		groupbuy.setMid(mid);
		groupbuyMapper.insert(groupbuy);
	}

}

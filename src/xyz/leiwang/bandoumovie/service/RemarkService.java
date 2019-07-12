package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.utils.PageBean;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:50:54
*/
public interface RemarkService {
	
	public void saveRemark(Remark remark) throws Exception;
	
	public void deleteRemarkByRid(Integer rid) throws Exception;
	
	public void updateRemark(Remark remark) throws Exception;
	
	public PageBean<Remark> findRemarkByPage(Integer page) throws Exception;
	
	public List<Remark> findAllRemark() throws Exception;
	
	// 按电影查询评论列表
	public List<Remark> findRemarkByMid(Integer mid) throws Exception;
	
	// 按用户查询评论列表
	public List<Remark> findRemarkByUid(Integer uid) throws Exception;
	
	// 按主键查询评论
	public Remark findRemarkByPrimaryKey(Integer rid) throws Exception;

}

package xyz.leiwang.bandoumovie.mapper;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Remark;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:54:09
*/
public interface RemarkMapper {
	
	// 根据主键删除
    int deleteByPrimaryKey(Integer rid);

    // 插入全部列
    int insert(Remark remark);
    
    // 插入部分列
    int insertSelective(Remark remark);
    
    // 更新
    int updateRemark(Remark remark);

    // 统计全部评论数量
	int countAllRemark();

	// 按页查询评论列表
	List<Remark> findRemarkByPage(int page, int limitPage);
	
	// 按电影查询评论列表
	List<Remark> findRemarkByMid(int mid);
	
	// 按用户查询评论列表
	List<Remark> findRemarkByUid(int uid);
	
	// 按主键查询评论
	Remark findRemarkByPrimaryKey(int rid);
	
	
	List<Remark> findAllRemark();

}

package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xyz.leiwang.bandoumovie.mapper.RemarkMapper;
import xyz.leiwang.bandoumovie.po.Remark;
import xyz.leiwang.bandoumovie.service.RemarkService;
import xyz.leiwang.bandoumovie.utils.PageBean;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:52:32
*/
public class RemarkServiceImpl implements RemarkService{
	
	@Autowired
	private RemarkMapper remarkMapper;

	@Override
	public void saveRemark(Remark remark) throws Exception {
		remarkMapper.insert(remark);
	}

	@Override
	public PageBean<Remark> findRemarkByPage(Integer page) throws Exception {
		PageBean<Remark> pageBean = new PageBean<>();
		pageBean.setPage(page);
		int limitPage = 5;
		pageBean.setLimitPage(limitPage);
		int totlePage = 0;
		totlePage = remarkMapper.countAllRemark();
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
		List<Remark> list = remarkMapper.findRemarkByPage(beginPage, limitPage) ;
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public List<Remark> findAllRemark() throws Exception{
		return remarkMapper.findAllRemark();
	}
	
	@Override	
	public void updateRemark(Remark remark) throws Exception{
		remarkMapper.updateRemark(remark);
	}

	@Override
	public void deleteRemarkByRid(Integer rid) throws Exception {
		remarkMapper.deleteByPrimaryKey(rid);
	}
	
	// 按电影查询评论列表
	@Override
	public List<Remark> findRemarkByMid(Integer mid) throws Exception{
		 List<Remark> list = remarkMapper.findRemarkByMid(mid) ;
		  
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
		
	}
	
	// 按用户查询评论列表
	@Override
	public List<Remark> findRemarkByUid(Integer uid) throws Exception{
		 List<Remark> list = remarkMapper.findRemarkByUid(uid) ;
		  
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
		
	}
	
	// 按主键查询评论
	@Override
	public Remark findRemarkByPrimaryKey(Integer rid) throws Exception{
		 Remark remark = remarkMapper.findRemarkByPrimaryKey(rid) ;
		  
		 if(remark!=null){
			 return remark;
		 }
		 return null;
		
	}

}

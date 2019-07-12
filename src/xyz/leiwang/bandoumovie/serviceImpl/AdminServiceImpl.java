package xyz.leiwang.bandoumovie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xyz.leiwang.bandoumovie.mapper.AdminMapper;
import xyz.leiwang.bandoumovie.po.Admin;
import xyz.leiwang.bandoumovie.po.AdminExample;
import xyz.leiwang.bandoumovie.po.AdminExample.Criteria;
import xyz.leiwang.bandoumovie.service.AdminService;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:52:11
*/
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin findAdminByUsername(String username) throws Exception {
		AdminExample example = new AdminExample();
		AdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Admin findAdminByAid(Integer aid) throws Exception {
		AdminExample example = new AdminExample();
		AdminExample.Criteria criteria = example.createCriteria();
		criteria.andAidEqualTo(aid);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveAdmin(Admin admin) throws Exception {
		adminMapper.insert(admin);
	}


/*	π‹¿Ì‘±µ«¬º*/
	@Override
	public Admin adminLogin(String username, String password)
			throws Exception {
		AdminExample example = new AdminExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username);
		createCriteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Admin> findAllAdmin() throws Exception {
		AdminExample example = new AdminExample();
		return adminMapper.selectByExample(example);
	}
	
	@Override
	public void deleteAdminByAid(int aid) throws Exception {
		adminMapper.deleteByPrimaryKey(aid);
	}
	
	@Override
	public void updateAdmin(Admin admin) throws Exception{
		adminMapper.updateByPrimaryKey(admin);
	}

}

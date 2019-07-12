package xyz.leiwang.bandoumovie.service;

import java.util.List;

import xyz.leiwang.bandoumovie.po.Admin;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:50:06
*/
public interface AdminService {
	
	public Admin findAdminByUsername(String username) throws Exception;
	
	public Admin findAdminByAid(Integer aid) throws Exception;

	public Admin adminLogin(String username, String password) throws Exception;
	
	public List<Admin> findAllAdmin() throws Exception;
	
	public void deleteAdminByAid(int aid) throws Exception;
	
	public void saveAdmin(Admin admin) throws Exception;
	
	public void updateAdmin(Admin admin) throws Exception;
}

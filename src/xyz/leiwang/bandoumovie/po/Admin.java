package xyz.leiwang.bandoumovie.po;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:37:30
*/
public class Admin {
	
    private Integer aid;

    private String username;

    private String password;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(Integer aid, String username, String password) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
	}

	public Admin() {
		super();
	}
    
	

}

package xyz.leiwang.bandoumovie.po;

import java.util.List;

import javax.validation.constraints.Size;



/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:39:04
*/
public class User {
	
    private Integer uid;
    @Size(min=2,max=30,message="{user.username.length.error}")
    private String username;

    private String password;

    private String uname;
    
    private String email;

    private String phone;

    private String addr;

    private Integer state;

    private String code;

    // 用户看过的电影列表
    private List<Movie> movieList;
    
    // 用户参加过的团购列表
    private List<Groupbuy> groupbuyList;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public List<Groupbuy> getGroupbuyList() {
		return groupbuyList;
	}

	public void setGroupbuyList(List<Groupbuy> groupbuyList) {
		this.groupbuyList = groupbuyList;
	}

	public User(Integer uid, String username, String password, String uname, String email, String phone, String addr,
			Integer state, String code, List<Movie> movieList, List<Groupbuy> groupbuyList) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.uname = uname;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.state = state;
		this.code = code;
		this.movieList = movieList;
		this.groupbuyList = groupbuyList;
	}

	public User() {
		super();
	}
	
	

}

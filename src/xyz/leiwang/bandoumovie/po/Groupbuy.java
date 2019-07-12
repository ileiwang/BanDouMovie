package xyz.leiwang.bandoumovie.po;

import java.util.Date;
import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 21:49:33
*/

/*团购*/
public class Groupbuy {
	
	// 团购编号
    private Integer gid;
    
    // 电影编号
    private Integer mid;

	private Date createdate;
    
    // 电影
    private Movie movie;
    
    // 团购用户列表
    private List<User> userList;
    
	public Integer getGid() {
		return gid;
	}

	public Integer getMid() {
		return mid;
	}

	public Movie getMovie() {
		return movie;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
    public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Groupbuy(Integer gid, Integer mid, Movie movie, List<User> userList) {
		super();
		this.gid = gid;
		this.mid = mid;
		this.movie = movie;
		this.userList = userList;
	}

	public Groupbuy() {
		super();
	}
	
	

}

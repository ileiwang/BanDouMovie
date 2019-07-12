package xyz.leiwang.bandoumovie.po;

import java.util.Date;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:38:34
*/
public class Remark {
	
	private Integer rid; 

	private String content;

	private Date remarkdate; 
	
	private Integer uid;
	
	private Integer mid;
	
	// 评论关联的用户
	private User user;
	
	// 评论关联的电影
	private Movie movie;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRemarkdate() {
		return remarkdate;
	}

	public void setRemarkdate(Date remarkdate) {
		this.remarkdate = remarkdate;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	public User getUser() {
		return user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Remark(Integer rid, String content, Date remarkdate, Integer uid, Integer mid, User user, Movie movie) {
		super();
		this.rid = rid;
		this.content = content;
		this.remarkdate = remarkdate;
		this.uid = uid;
		this.mid = mid;
		this.user = user;
		this.movie = movie;
	}

	public Remark() {
		super();
	}
	
	

}

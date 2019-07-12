package xyz.leiwang.bandoumovie.po;

import java.util.Date;
import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 21:49:33
*/

/*�Ź�*/
public class Groupbuy {
	
	// �Ź����
    private Integer gid;
    
    // ��Ӱ���
    private Integer mid;

	private Date createdate;
    
    // ��Ӱ
    private Movie movie;
    
    // �Ź��û��б�
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

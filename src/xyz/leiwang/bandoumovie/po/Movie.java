package xyz.leiwang.bandoumovie.po;

import java.util.Date;
import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:38:07
*/
public class Movie {
	
    private Integer mid;

    private String name;

    private String region;

    private String image;

    private String mdesc;

    private Date date;

    private Integer cid;

    // 看过该电影的用户列表
	private List<User> userList;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

    public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Movie(Integer mid, String name, String region, String image, String mdesc, Date date, Integer cid,
			List<User> userList) {
		super();
		this.mid = mid;
		this.name = name;
		this.region = region;
		this.image = image;
		this.mdesc = mdesc;
		this.date = date;
		this.cid = cid;
		this.userList = userList;
	}

	public Movie() {
		super();
	}
	
	
}

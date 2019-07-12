package xyz.leiwang.bandoumovie.po;

import java.util.List;


/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:37:49
*/
public class Category {
	
    private Integer cid;

    private String cname;
   
	private List<Movie> movieList;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
    public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public Category(Integer cid, String cname, List<Movie> movieList) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.movieList = movieList;
	}

	public Category() {
		super();
	}
	
	

}

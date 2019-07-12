package xyz.leiwang.bandoumovie.utils;

import java.util.List;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:48:32
*/
public class PageBean<T> {
	private int page;//�ڼ�ҳ
	private int totlePage;//һ������ҳ
	private int limitPage;//ÿҳ���ٸ�
	private List<T> list;//Ŀ�꼯��
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getLimitPage() {
		return limitPage;
	}
	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String toString() {
		return "PageBean [page=" + page + ", totlePage=" + totlePage
				+ ", limitPage=" + limitPage + ", list=" + list + "]";
	}

}

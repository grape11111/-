package edu.gdut.imis.product.common;

import java.util.List;

public class PageBean<T> {
	private int totalPage;//总页数
	private int currPage;//当前页
	private int pageSize;//每一页的记录数
	List<T> pagelist;//用于存放当前页的记录
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<T> pagelist) {
		this.pagelist = pagelist;
	}
	
}

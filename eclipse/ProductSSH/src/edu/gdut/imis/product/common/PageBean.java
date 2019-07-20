package edu.gdut.imis.product.common;

import java.util.List;

public class PageBean<T> {
	private int totalPage;//��ҳ��
	private int currPage;//��ǰҳ
	private int pageSize;//ÿһҳ�ļ�¼��
	List<T> pagelist;//���ڴ�ŵ�ǰҳ�ļ�¼
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

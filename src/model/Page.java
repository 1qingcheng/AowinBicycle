package model;

import java.util.List;

public class Page {
	private int currentPage;//当前第几页
	private int start;// 数据库从第几条数据开始
	private int totalPage;// 总页数
	private int pageSize;// 每页显示的记录条数
	private List data;// 当前页要显示的数据

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}

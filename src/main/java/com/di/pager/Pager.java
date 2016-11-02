package com.di.pager;

import java.util.List;

public class Pager<T> {
	int pageNum;
	int pageSize;
	long totals;
	List<T> list;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotals() {
		return totals;
	}

	public void setTotals(long totals) {
		this.totals = totals;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}

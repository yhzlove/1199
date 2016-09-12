package com.y.entity;

import java.util.List;
import java.util.Map;

public class PageView {
	
	
	private List<?> rows;   		//记录
	private int total;				//总数
	private int pageNow = 1;		//当前页数
	private int pagecode = 10;		//显示条数
	
	private int offset;
	private int limit;
	private String order;
	
	private String sort;
	private Map<String, String> params;
	
	
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPagecode() {
		return pagecode;
	}
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	
	
	
}

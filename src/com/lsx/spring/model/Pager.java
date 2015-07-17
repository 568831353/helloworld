package com.lsx.spring.model;

import java.util.List;
/*
 * 
 * 分页类
 * 
 * */

public class Pager<T> {
    private List<T> datas;    //一页的数据
	private int offset;  //当前页第一条
	private int  size;    //一页显示多少条
	private long total;   //总数据的数目
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
}

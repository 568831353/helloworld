package com.lsx.spring.model;

import java.util.List;
/*
 * 
 * ��ҳ��
 * 
 * */

public class Pager<T> {
    private List<T> datas;    //һҳ������
	private int offset;  //��ǰҳ��һ��
	private int  size;    //һҳ��ʾ������
	private long total;   //�����ݵ���Ŀ
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

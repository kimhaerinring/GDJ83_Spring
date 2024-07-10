package com.sun.app.accounts;

public class ListOption {
	private String ac_num;
	private Integer order;// 0이면 desc ,1 asc
	private Integer oo;

	public Integer getOo() {
		return oo;
	}

	public void setOo(Integer oo) {
		this.oo = oo;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}

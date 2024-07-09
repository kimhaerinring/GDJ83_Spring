package com.sun.app.records;

import java.sql.Date;

public class RecordsDTO {
	private String ac_num;
	private Long balance;
	private Date period;
	private String other_num;
	private Long money;

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public String getOther_num() {
		return other_num;
	}

	public void setOther_num(String other_num) {
		this.other_num = other_num;
	}

}

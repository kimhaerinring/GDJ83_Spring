package com.sun.app.trades;

import java.sql.Date;

public class TradeDTO {
	// 거래번호
	private Long tradeNum;
	// 내 계좌번호
	private String accountNumber;
	// 거래 후 잔액
	private Long tradebalance;
	// 거래일
	private Date tradeDate;
	// 다른 사람계좌번호
	private String receiveNumber;
	// 거래 금액
	private Long tradeAmount;
	// 입출금 구분, 0:입금,1:출금
	private Integer tradeIO;

	public String getReceiveNumber() {
		return receiveNumber;
	}

	public void setReceiveNumber(String receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getTradebalance() {
		return tradebalance;
	}

	public void setTradebalance(Long tradebalance) {
		this.tradebalance = tradebalance;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Long getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Long tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Integer getTradeIO() {
		return tradeIO;
	}

	public void setTradeIO(Integer tradeIO) {
		this.tradeIO = tradeIO;
	}

	public Long getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(Long tradeNum) {
		this.tradeNum = tradeNum;
	}

}

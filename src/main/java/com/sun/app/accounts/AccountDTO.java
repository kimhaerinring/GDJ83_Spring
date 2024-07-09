package com.sun.app.accounts;

import java.sql.Date;

import com.sun.app.member.MemberDTO;
import com.sun.app.product.ProductDTO;

public class AccountDTO {
	private String ac_num;
	private String id;
	private String p_code;
	private Long a_balance;
	private Date a_date;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public Long getA_balance() {
		return a_balance;
	}

	public void setA_balance(Long a_balance) {
		this.a_balance = a_balance;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

}
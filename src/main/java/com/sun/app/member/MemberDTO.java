package com.sun.app.member;

import java.util.List;

import com.sun.app.accounts.AccountDTO;

public class MemberDTO {
	private String id;
	private String phone;
	private String password;
	private String name;
	private String ss_num;
	private String email;
	private List<AccountDTO> dtos;
	private MemberFileDTO memberFileDTO;

	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}

	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}

	public List<AccountDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSs_num() {
		return ss_num;
	}

	public void setSs_num(String ss_num) {
		this.ss_num = ss_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

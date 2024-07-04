package com.sun.app.member;

public class MemberDTO {
	private String id;
	private String phone;
	private String password;
	private String name;
	private String ss_num;
	private String email;

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

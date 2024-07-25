package com.sun.app.product;

import java.sql.Date;

public class ProductCommentsDTO {
	private Integer comments_num;
	private String id;
	private  String p_code;
	private String comments_Content;
	private Date comments_Date;
	public Integer getComments_num() {
		return comments_num;
	}
	public void setComments_num(Integer comments_num) {
		this.comments_num = comments_num;
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
	public String getComments_Content() {
		return comments_Content;
	}
	public void setComments_Content(String comments_Content) {
		this.comments_Content = comments_Content;
	}
	public Date getComments_Date() {
		return comments_Date;
	}
	public void setComments_Date(Date comments_Date) {
		this.comments_Date = comments_Date;
	}
	
}

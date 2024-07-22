package com.sun.app.product;

import java.util.List;

public class ProductDTO {
	private String p_code;
	private String ac_name;
	private Double interest;
	private String script;
	private List<ProductFileDTO> fileDTOs;
	

	public List<ProductFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<ProductFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

}

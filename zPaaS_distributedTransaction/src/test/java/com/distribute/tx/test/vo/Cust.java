package com.distribute.tx.test.vo;

import java.io.Serializable;

public class Cust implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4657841950462320872L;
	private Long custId;
	private String name;
	private String certType;
	private String certCode;
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	
	
}

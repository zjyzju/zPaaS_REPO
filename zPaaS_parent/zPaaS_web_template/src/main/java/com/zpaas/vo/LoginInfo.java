package com.zpaas.vo;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class LoginInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5467544463410055907L;
	private String loginName;//登陆名
	private String loginPass;//登陆密码
	private String vilicode;//验证码
	private String passRandom ;//随机数
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getVilicode() {
		return vilicode;
	}
	public void setVilicode(String vilicode) {
		this.vilicode = vilicode;
	}
	public String getPassRandom() {
		return passRandom;
	}
	public void setPassRandom(String passRandom) {
		this.passRandom = passRandom;
	}
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}

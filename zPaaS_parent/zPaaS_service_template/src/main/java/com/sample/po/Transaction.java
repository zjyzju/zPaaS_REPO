package com.sample.po;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 6607771979091605802L;
	
	private String name;
	private Integer participantNum;
	private String participants;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParticipantNum() {
		return participantNum;
	}
	public void setParticipantNum(Integer participantNum) {
		this.participantNum = participantNum;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}

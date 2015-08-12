package com.zpaas.message;

import java.io.Serializable;

/**
 * 消息服务-消息对象类
 * @author ZhangJunyong
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = -3467986354628250193L;
	private String topic;
	private Object msg;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getId()).append(":").append(this.getTopic()).append(":");
		sb.append(this.getMsg());
		return sb.toString();
	}
}

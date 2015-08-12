package com.zpaas.message;


/**
 * 消息服务-消息监听接口类
 * @author ZhangJunyong
 *
 */
public interface MessageListener {
	public void receiveMessage(Message message, MessageStatus status);
}

package com.zpaas.test;

import com.zpaas.message.Message;
import com.zpaas.message.MessageListener;
import com.zpaas.message.MessageStatus;

/**
 * 消息监听示例类
 * @author ZhangJunyong
 *
 */
public class MessageListenerSample implements MessageListener {

	public void receiveMessage(Message message, MessageStatus status) {
		System.out.println(message.getMsg());
	}

}

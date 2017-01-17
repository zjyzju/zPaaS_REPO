package com.zpaas.message;



public interface MessageSender {
	public void sendMessage(Object message, String topic);
	public void sendMessage(Object message, String topic, String key);
}

package com.sp.chat.model.vo;

public class ChatContent {
	private String userNickName;
	private String chatContent;
	private String time;
	
	public ChatContent() {
		super();
	}

	public ChatContent(String userNickName, String chatContent, String time) {
		super();
		this.userNickName = userNickName;
		this.chatContent = chatContent;
		this.time = time;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ChatContent [userNickName=" + userNickName + ", chatContent=" + chatContent + ", time=" + time + "]";
	}
	
}

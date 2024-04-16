package com.example.TicketRestApi;

import java.util.Date;

public class Comment {
	private String text;
    private String author;
    private Date sendingTime;
    
	public Comment(String text, String author) {
		this.text = text;
		this.author = author;
		this.sendingTime=new Date();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getSendingTime() {
		return sendingTime;
	}
	public void setSendingTime(Date sendingTime) {
		this.sendingTime = sendingTime;
	}
    
}

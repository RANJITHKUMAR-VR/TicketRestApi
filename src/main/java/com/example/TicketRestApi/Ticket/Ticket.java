package com.example.TicketRestApi.Ticket;

import java.util.Date;
import java.util.List;

import com.example.TicketRestApi.Comment;

//ticket interface

public interface Ticket {
	String getTitle();
	String getDescription();
	String getPriority();
	String getStatus();
	String getTicketId();
	String getUserId();
	List<Comment> getComments();
	Date getCreatedAt();
	Date getLastModifiedAt();
	void setStatus(String s);

}

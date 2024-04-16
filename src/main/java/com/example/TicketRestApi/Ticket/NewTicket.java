package com.example.TicketRestApi.Ticket;
import com.example.TicketRestApi.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ticket")
public class NewTicket implements Ticket {
	@Id
	private String id;
	private String ticketId;
	private String userId;
	private String title;
	private String description;
	private String priority;
	private String status;
    private List<Comment> comments=new ArrayList<>();
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date lastModifiedAt;
	public NewTicket(String userId,String title,String description) {
		this.ticketId=this.generateCustomTicketId();
		this.userId=userId;
		this.title=title;
		this.description=description;
		this.status="open";
		this.priority="low";
	}
	public String getUserId() {
		return userId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getPriority() {
		return priority;
	}
	public void setStatus(String s) {
		this.status=s;
	}
	public String getStatus() {
		return status;
	}
	public String getTicketId() {
		return this.ticketId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	
	public List<Comment> getComments() {
		if(comments!=null) {
		return comments;
		}
		return new ArrayList<>();
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	private String generateCustomTicketId() {
	    String uniqueId = "TICKET-"+ UUID.randomUUID().toString().substring(0,8);
	    return uniqueId;
	 }
	@Override
	public String toString() {
		return "NewTicket [ticketId=" + ticketId + ", userId=" + userId + ", title=" + title + ", description="
				+ description + ", priority=" + priority + ", status=" + status + ", comments=" + comments
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
	}
	
}

package com.example.TicketRestApi.User;


import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User implements Customer{
    @Id
    private String id;
    private String userId;
	private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String address;
    private String status;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date lastModifiedAt;
	public User( String firstname, String lastname, String email, String phonenumber, String address,String status) {
		this.userId=this.generateCustomTicketId();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	private String generateCustomTicketId() {
		 UUID uuid = UUID.randomUUID();
	     String shortId = uuid.toString().replaceAll("-", "").substring(0, 8); 
	     return shortId;
	 }
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", address=" + address + ", status=" + status
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
	}
	
}

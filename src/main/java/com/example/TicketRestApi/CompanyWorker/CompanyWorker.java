package com.example.TicketRestApi.CompanyWorker;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="worker")
public class CompanyWorker {
	@Id
	 private String id;
	 private String workerId;
	 private String name;
	 private String assignWork;
	 @CreatedDate
	 private Date createdAt;
	 @LastModifiedDate
	 private Date lastModifiedAt;
	 public CompanyWorker(String workerId,String name) {
		this.workerId=workerId; 
		this.name = name;
		this.assignWork=null;
     }
	 public String getAssignWork() {
		return assignWork;
	 }
	 public void setAssignWork(String assignWork) {
	 	this.assignWork = assignWork;
	 }
	 public String getId() {
	 	return id;
	 }
	 public void setId(String id) {
	 	this.id = id;
	 }
	 public String getName() {
	 	return name;
	 }
	 public void setName(String name) {
		this.name = name;
	 }
	 public String getWorkerId() {
	 	return workerId;
	 }
	 public void setWorkerId(String workerId) {
	 	this.workerId = workerId;
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
	 @Override
		public String toString() {
			return "CompanyWorker [workerId=" + workerId + ", name=" + name + ", assignWork=" + assignWork + ", createdAt="
					+ createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
		}
}

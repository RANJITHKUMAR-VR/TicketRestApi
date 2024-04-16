package com.example.TicketRestApi.User;

import java.util.Date;

public interface Customer {
	 String getUserId();
	 String getFirstname();
	 String getLastname();
	 String getEmail();
	 String getPhonenumber();
	 String getAddress();
	 Date getCreatedAt();
	 Date getLastModifiedAt();
}

package com.example.TicketRestApi.User;
import com.example.TicketRestApi.Ticket.*;
import com.example.TicketRestApi.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	 private UserService userService;
	 
	//enter the user email and get the detail
	 @GetMapping("/get/{email}")
	 public String get(@PathVariable String email) {
	     Optional<User> user=userService.getUser(email);
		 return user.map(users->"user found"+users.toString()).orElse("This Email-Id No User Match");
	 }
	 
	//create new user
	 @PostMapping("/create")
	 public String createUser(@RequestBody User user) {
	 	return userService.createUser(user);
	 }
	 
	 //create ticket
	 @PostMapping("/create-ticket")
	 public String createTicket(@RequestBody NewTicket ticket) {
		 return userService.createTicket(ticket);
	 }
	 
	 //view ticket by enter the user id
	 @GetMapping("/view-ticket/{userId}")
	 public String viewTicket(@PathVariable String userId) {
		 Optional<List<NewTicket>> ticket=userService.viewTicket(userId);
		 return ticket.map((tic->"ticket"+ticket.toString())).orElse("not found");
	 }
	 
	 //add comment to the ticket by enter the tickerid
	@PostMapping("/{ticketId}/comments")
	public String comment(@PathVariable String ticketId,@RequestBody Comment comment) {
		return userService.comment(ticketId,comment);
	}
}

//format
/* 
{
    "firstname":"Ranjithkumar",
    "lastname":"V.R",
    "email":"ranjithkumar@gamil.com",
    "phonenumber":"1234567890",
    "address":"494 south street",
    "status":"open"
}
*/

//----------
/*
{
 "userId":"bdb87514",
"title":"problem on phone",
"description":"my device not working"
}
*/

/*
{
"text":"i send",
"author":"ranjith"
}
*/

/*
{
"workerId":"1",
"name":"karthick"
}
*/
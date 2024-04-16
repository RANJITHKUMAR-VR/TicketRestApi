package com.example.TicketRestApi.Admin;

import com.example.TicketRestApi.User.*;
import com.example.TicketRestApi.Ticket.*;
import com.example.TicketRestApi.CompanyWorker.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@GetMapping("/get-all-user")
	public List<User>getAllUser(){
		return adminService.getAllUser();
	}
	@GetMapping("/get-all-ticket")
	public List<NewTicket>getAllTicket(){
		return adminService.getAllTicket();
	}
	@GetMapping("/get-all-worker")
	public List<CompanyWorker>getAllWorker(){
		return adminService.getAllWorker();
	}
	@PostMapping("/{tokenId}/assign/{workerId}")
	  public String assignTokenToWorker(@PathVariable String tokenId, @PathVariable String workerId) {
        return adminService.assignTokenToWorker(tokenId, workerId);
    }
	@GetMapping("/getuser/{id}")
	public String getUser(@PathVariable String id){
		Optional<User>user=adminService.getUser(id);
		return user.map((obj)->obj.toString()).orElse("No User Found This Id");
	}
	@GetMapping("/getticket/{id}")
	public String getTicket(@PathVariable String id){
		return adminService.getTicket(id).map((obj)->obj.toString()).orElse("Not Found This Ticket ");
	}
	@GetMapping("/getworker/{id}")
	public String getWorker(@PathVariable String id){
		return adminService.getWorker(id).map((obj)->obj.toString()).orElse("Not Found This WorkerID");
	}
}

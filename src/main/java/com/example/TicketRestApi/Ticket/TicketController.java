package com.example.TicketRestApi.Ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
    @PostMapping("/create-ticket")
    public String createTicket(@RequestBody NewTicket ticket) {
	return ticketService.createTicket(ticket)?"succesfully ticket created":"not success";
    }
	@GetMapping("/get-ticket/{id}")//send the user id
	public List<NewTicket> getTicket(@PathVariable String id) {
		return ticketService.getTicket(id);
	}
}

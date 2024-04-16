package com.example.TicketRestApi.Ticket;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired

	TicketRepository ticketRepository;
	
	public boolean createTicket(NewTicket ticket) {
		ticket.setCreatedAt(new Date());
		ticket.setLastModifiedAt(new Date());
		ticketRepository.save(ticket);
		return true;
	}
	public List<NewTicket> getTicket(String id) {//userid
		List<NewTicket>newTicketList=ticketRepository.findTicketByUserId(id);
		return newTicketList;
	}
}

package com.example.TicketRestApi.CompanyWorker;
import com.example.TicketRestApi.Ticket.*;
import com.example.TicketRestApi.Comment;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyWorkerService {
	@Autowired
	CompanyWorkerRepository companyWorkerRepository;
	@Autowired
	TicketRepository ticketRepository;
	public String createWorker(CompanyWorker worker) {
		CompanyWorker presentWorker=companyWorkerRepository.findworkerByIdQuery(worker.getWorkerId());
		if(presentWorker==null&&(worker.getWorkerId()!=null&&worker.getName()!=null)) {
		worker.setCreatedAt(new Date());
		worker.setLastModifiedAt(new Date());
		companyWorkerRepository.save(worker);
		return "successfully created";
		}
		return "not Sucessfully created";
	}
	public List<Comment> getComment(String ticketId) {
		List<NewTicket>listOfTicket=ticketRepository.findAll();
		for(NewTicket ticket:listOfTicket) {
			if(ticket.getTicketId().equals(ticketId)) {
				return ticket.getComments();
			}
		}
		return null;
	}
	public String comment(String ticketId,Comment comment) {
		NewTicket ticket=ticketRepository.findTicketByIdQuery(ticketId);
		if(ticket!=null) {
			ticket.getComments().add(comment);
			ticket.setLastModifiedAt(new Date());
			ticketRepository.save(ticket);
			return "successfully commented";
		}
		return "not Success";
	}
	public String updateStatus(String ticketId,String status) {
		List<NewTicket>listOfTicket=ticketRepository.findAll();
        NewTicket t=ticketRepository.findTicketByIdQuery(ticketId);
		listOfTicket.stream().filter((obj)->obj.getTicketId().equals(ticketId)).forEach((obj)->{obj.setStatus(status);obj.setLastModifiedAt(new Date());ticketRepository.save(obj);});
		return t!=null?"success":"not success";
	}
	public Optional<CompanyWorker> getWorker(String id) {
		CompanyWorker worker=companyWorkerRepository.findworkerByIdQuery(id);
		return Optional.ofNullable(worker);
	}
}

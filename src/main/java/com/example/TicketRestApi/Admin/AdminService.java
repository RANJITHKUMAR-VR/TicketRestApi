package com.example.TicketRestApi.Admin;

import com.example.TicketRestApi.User.*;
import com.example.TicketRestApi.Ticket.*;
import com.example.TicketRestApi.CompanyWorker.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	CompanyWorkerRepository companyWorkerRepository;
	public List<User>getAllUser(){
		return userRepository.findAll();
	}
	public List<NewTicket> getAllTicket(){
		return ticketRepository.findAll();
	}
	public List<CompanyWorker>getAllWorker(){
		return companyWorkerRepository.findAll();
	}
    public String assignTokenToWorker(String ticketId,String workerId) {
    	List<NewTicket>listOfTicket=ticketRepository.findAll();
    	Stream<NewTicket>ticket=listOfTicket.stream().filter((obj)->obj.getTicketId().equals(ticketId));
    	List<CompanyWorker>listOfWorker=companyWorkerRepository.findAll();
    	if(ticket!=null) {
    		for(CompanyWorker worker:listOfWorker) {
        		if(worker.getWorkerId().equals(workerId)) {
        			worker.setAssignWork(ticketId);
            		companyWorkerRepository.save(worker);
            		
            		ticket.forEach((obj)->{
            			obj.setStatus("isProgress");
            			ticketRepository.save(obj);
            			});
            		
            		return "successfully assigned";
        		}
        	}
    	}
    	return "not success";
	}
	public Optional<User> getUser(String id) {
		return Optional.ofNullable(userRepository.findUsersByIdQuery(id));
	}
	public Optional<NewTicket> getTicket(String id) {
		 return Optional.ofNullable(ticketRepository.findTicketByIdQuery(id));
	}
	public Optional<CompanyWorker> getWorker(String id) {
		return Optional.ofNullable(companyWorkerRepository.findworkerByIdQuery(id));
	}
}

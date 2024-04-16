package com.example.TicketRestApi.User;
import com.example.TicketRestApi.Ticket.*;
import com.example.TicketRestApi.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	RestTemplate restTemplate;
	public String createUser(User user) {	
		user.setCreatedAt(new Date());
		user.setLastModifiedAt(new Date());
		User users=userRepository.findUsersByemailQuery(user.getEmail());
			if(users!=null&&(users.getEmail().equals(user.getEmail()))) {
				return "this email is already used";
			}
	 userRepository.save(user);
	 return "successfully inserted";
	}
	public Optional<User> getUser(String email) {
		return Optional.ofNullable( userRepository.findUsersByemailQuery(email));
	}
	public String createTicket(NewTicket ticket) {
		return restTemplate.postForObject("http://localhost:8080/ticket/create-ticket", ticket, String.class);
	}
	public Optional<List<NewTicket>> viewTicket(String userId) {
	    String apiUrl = "http://localhost:8080/ticket/get-ticket/"+userId;
        HttpEntity<Void> requestEntity = new HttpEntity<>(null);
        ResponseEntity<List> responseEntity = restTemplate.exchange(apiUrl,HttpMethod.GET, requestEntity,List.class ); 
        List<NewTicket> newTickets = responseEntity.getBody();
        return Optional.ofNullable(newTickets);
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
}

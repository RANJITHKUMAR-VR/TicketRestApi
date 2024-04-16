package com.example.TicketRestApi.Ticket;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TicketRepository extends MongoRepository<NewTicket,String> {
	@Query("{ 'ticketId' : ?0 }")
	NewTicket findTicketByIdQuery(String id);
	@Query("{ 'userId' : ?0 }")
	List<NewTicket> findTicketByUserId(String id);
}

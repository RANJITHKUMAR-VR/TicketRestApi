package com.example.TicketRestApi.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {
	 @Query("{ 'email' : ?0 }")
	 User findUsersByemailQuery(String email);
	 @Query("{ 'userId' : ?0 }")
	 User findUsersByIdQuery(String userId);
}

package com.example.TicketRestApi.CompanyWorker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CompanyWorkerRepository extends MongoRepository<CompanyWorker,String> {
	@Query("{ 'workerId' : ?0 }")
    CompanyWorker findworkerByIdQuery(String workerId);
}

package com.example.TicketRestApi.CompanyWorker;
import com.example.TicketRestApi.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class CompanyWorkerController {
	@Autowired
	CompanyWorkerService companyWorkerService;
	@GetMapping("/get-worker/{id}")
	public String getWorker(@PathVariable String id) {
		return companyWorkerService.getWorker(id).map((obj)->obj.toString()).orElse("Enter The Correct Id");
	}
	@PostMapping("/create-worker")
	public String createWorker(@RequestBody CompanyWorker worker) {
		return companyWorkerService.createWorker(worker);
	}
	@PostMapping("/{ticketId}/comments")
	public String comment(@PathVariable String ticketId,@RequestBody Comment comment) {
		return companyWorkerService.comment(ticketId,comment);
	}
	@PutMapping("/{ticketId}/update-status/{status}")
	public String updateStatus(@PathVariable String ticketId,@PathVariable String status) {
		return companyWorkerService.updateStatus(ticketId,status);
	}
}
/*
{
"workerId":"1",
"name":"karthick"
}
*/
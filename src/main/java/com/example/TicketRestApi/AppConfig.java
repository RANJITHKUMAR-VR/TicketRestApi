package com.example.TicketRestApi;
import com.example.TicketRestApi.CompanyWorker.CompanyWorkerService;
import com.example.TicketRestApi.Ticket.TicketService;
import com.example.TicketRestApi.User.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public UserService userService() {
    	return new UserService();
    }
    @Bean
    public TicketService ticketService() {
    	return new TicketService();
    }
    @Bean
    public CompanyWorkerService companyWorkerService() {
    	return new  CompanyWorkerService ();
    }
}


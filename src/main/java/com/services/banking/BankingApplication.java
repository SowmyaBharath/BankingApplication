package com.services.banking;


//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BankingApplication {
	//private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BankingApplication.class);

	    public static void main(String[] args) {

	        SpringApplication.run(BankingApplication.class, args);
	       // LOGGER.info("Application started!");
	    }

}

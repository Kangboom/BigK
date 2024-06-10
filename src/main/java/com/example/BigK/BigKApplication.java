package com.example.BigK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BigKApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigKApplication.class, args);
	}

}

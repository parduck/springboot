package com.sec.admin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sec.admin", "com.sec"})
@EnableJpaRepositories(basePackages = {"com.sec.persistence" })
public class AdminApplication {

	public static void main(String[] args) {
		 SpringApplication.run(AdminApplication.class, args); 
		/*
		 * SpringApplication application = new
		 * SpringApplication(AdminApplication.class);
		 * application.setWebApplicationType(WebApplicationType.NONE);
		 * application.run(args);
		 */
	}

}

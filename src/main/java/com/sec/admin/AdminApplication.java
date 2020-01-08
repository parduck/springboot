package com.sec.admin;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages= {"com.sec.admin", "com.sec"} )
public class AdminApplication {
 
	public static void main(String[] args) { 
		SpringApplication.run(AdminApplication.class, args);
	}

}

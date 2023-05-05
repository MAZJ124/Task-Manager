package com.taskmanager.taskmanagerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootTaskManagerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTaskManagerAppApplication.class, args);
	}

}

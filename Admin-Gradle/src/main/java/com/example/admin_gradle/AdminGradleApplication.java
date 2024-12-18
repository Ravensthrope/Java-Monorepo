package com.example.admin_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminGradleApplication.class, args);
	}

}

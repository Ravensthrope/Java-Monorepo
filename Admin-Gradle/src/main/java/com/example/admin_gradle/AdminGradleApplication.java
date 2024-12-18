package com.example.admin_gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminGradleApplication {
    private static final Logger logger = LoggerFactory.getLogger(AdminGradleApplication.class);

	public static void main(String[] args) {
        logger.info("Starting AdminGradleApplication...");
		SpringApplication.run(AdminGradleApplication.class, args);
        logger.info("Starting AdminGradleApplication...");
	}

}

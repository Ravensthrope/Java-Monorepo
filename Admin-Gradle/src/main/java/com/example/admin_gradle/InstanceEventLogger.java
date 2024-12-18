package com.example.admin_gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.codecentric.boot.admin.server.domain.events.InstanceDeregisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceRegisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import jakarta.annotation.PostConstruct;

@Component
public class InstanceEventLogger {
    private static final Logger logger = LoggerFactory.getLogger(InstanceEventLogger.class);

    @EventListener
    public void handleInstanceRegisteredEvent(InstanceRegisteredEvent event) {
        logger.info("Client Application Registered: Name = {}, ID = {}, Source = {}",
            event.getRegistration().getName(),
            event.getInstance(),
            event.getRegistration().getSource());
    }

    @EventListener
    public void handleInstanceDeregisteredEvent(InstanceDeregisteredEvent event) {
        logger.info("Client Application Deregistered: Instance = {}", event.getInstance());
    }

    @EventListener
    public void handleInstanceStatusChangedEvent(InstanceStatusChangedEvent event) {
        logger.info("Client Application Status Changed: Instance = {}, New Status = {}, Details = {}",
            event.getInstance(),
            event.getStatusInfo().getStatus(),
            event.getStatusInfo().getDetails());
    }

    @PostConstruct
    public void init() {
        logger.info("InstanceEventLogger initialized and ready to track application events!");
    }
}

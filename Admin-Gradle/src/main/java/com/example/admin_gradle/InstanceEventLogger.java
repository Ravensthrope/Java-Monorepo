package com.example.admin_gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceRegisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import jakarta.annotation.PostConstruct;

@Component
public class InstanceEventLogger {

    private static final Logger log = LoggerFactory.getLogger(InstanceEventLogger.class);

    @PostConstruct
    public void init() {
        log.info("InstanceEventLogger initialized!");
    }

    @EventListener
    public void onInstanceEvent(InstanceEvent event) {
        log.info("Event received: {}", event.getClass().getSimpleName());
        if (event instanceof InstanceRegisteredEvent) {
            log.info("Instance registered: {}", event.getInstance());
        } else if (event instanceof InstanceStatusChangedEvent) {
            InstanceStatusChangedEvent statusEvent = (InstanceStatusChangedEvent) event;
            log.info("Instance status changed to {}: {}", statusEvent.getStatusInfo().getStatus(), event.getInstance());
        }
    }
}

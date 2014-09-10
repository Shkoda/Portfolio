package com.pelican.core.event.task;

import com.pelican.core.event.CreatedEvent;
import lombok.ToString;

import java.util.UUID;

@ToString
public class TaskCreatedEvent extends CreatedEvent {

    private final UUID newOrderKey;
    private final TaskDetails details;

    public TaskCreatedEvent(final UUID newOrderKey, final TaskDetails details) {
        this.newOrderKey = newOrderKey;
        this.details = details;
    }

    public UUID getNewOrderKey() {
        return newOrderKey;
    }

    public TaskDetails getDetails() {
        return details;
    }
}

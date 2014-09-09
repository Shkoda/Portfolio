package com.pelican.core.event.task;

import com.pelican.core.event.CreateEvent;
import lombok.ToString;

@ToString
public class CreateOrderEvent extends CreateEvent {
    private TaskDetails details;

    public CreateOrderEvent(TaskDetails details) {
        this.details = details;
    }

    public TaskDetails getDetails() {
        return details;
    }
}

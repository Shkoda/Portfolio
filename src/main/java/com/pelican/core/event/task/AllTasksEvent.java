package com.pelican.core.event.task;

import com.pelican.core.event.ReadEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllTasksEvent extends ReadEvent {

    private final List<TaskDetails> ordersDetails;

    public AllTasksEvent(List<TaskDetails> orders) {
        this.ordersDetails = Collections.unmodifiableList(orders);
    }

    public Collection<TaskDetails> getOrdersDetails() {
        return this.ordersDetails;
    }
}

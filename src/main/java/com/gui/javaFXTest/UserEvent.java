package com.gui.javaFXTest;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class UserEvent extends Event {

    // ATTs
    public static final EventType<UserEvent> ANY = new EventType<>(Event.ANY, "ANY");

    public static final EventType<UserEvent> LOGIN_SUCCEED = new EventType<>(ANY, "LOGIN_SUCCEEDED");

    public static final EventType<UserEvent> LOGIN_FAILED = new EventType<>(ANY, "LOGIN_FAILED");

    // CONs
    public UserEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public UserEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }
}

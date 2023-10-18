package com.myspace.listeners;

import org.kie.api.event.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomProcessEventsListener implements ProcessEventListener {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomProcessEventsListener.class);
    public void beforeProcessStarted(ProcessStartedEvent processStartedEvent) {
    }

    public void afterProcessStarted(ProcessStartedEvent processStartedEvent) {

    }

    public void beforeProcessCompleted(ProcessCompletedEvent processCompletedEvent) {

    }

    public void afterProcessCompleted(ProcessCompletedEvent processCompletedEvent) {

    }

    public void beforeNodeTriggered(ProcessNodeTriggeredEvent processNodeTriggeredEvent) {

    }

    public void afterNodeTriggered(ProcessNodeTriggeredEvent processNodeTriggeredEvent) {

    }

    public void beforeNodeLeft(ProcessNodeLeftEvent processNodeLeftEvent) {

    }

    public void afterNodeLeft(ProcessNodeLeftEvent processNodeLeftEvent) {

    }

    public void beforeVariableChanged(ProcessVariableChangedEvent processVariableChangedEvent) {

    }

    public void afterVariableChanged(ProcessVariableChangedEvent processVariableChangedEvent) {

    }
}

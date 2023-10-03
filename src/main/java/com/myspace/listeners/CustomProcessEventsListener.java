package com.myspace.listeners;

import org.json.simple.JSONObject;
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

        JSONObject jsonObject = new JSONObject();


        URL url = null;
        try {
            url = new URL("http://localhost:8089/process/jbpm-salesforce-integration.process_new_case/start");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            OutputStream os = con.getOutputStream();
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

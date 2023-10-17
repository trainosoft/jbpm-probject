package com.myspace.listeners;

import org.json.simple.JSONObject;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomTaskEventListener implements TaskLifeCycleEventListener {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomTaskEventListener.class);

    public void beforeTaskActivatedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskClaimedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskSkippedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskStartedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskStoppedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskCompletedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskFailedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskAddedEvent(TaskEvent taskEvent) {


    }

    public void beforeTaskExitedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskReleasedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskResumedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskSuspendedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskForwardedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskDelegatedEvent(TaskEvent taskEvent) {

    }

    public void beforeTaskNominatedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskActivatedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskClaimedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskSkippedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskStartedEvent(TaskEvent taskEvent) {
       
    }

    public void afterTaskStoppedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskCompletedEvent(TaskEvent taskEvent) {
       
    }

    public void afterTaskFailedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskAddedEvent(TaskEvent taskEvent) {
            logger.info("after task added invoked ");

        JSONObject jsonObject = new JSONObject();
            jsonObject.put("taskId", taskEvent.getTask().getId());
        jsonObject.put("inputVariables", taskEvent.getTask().getTaskData().getTaskInputVariables());
        jsonObject.put("outputVariables", taskEvent.getTask().getTaskData().getTaskOutputVariables());
        jsonObject.put("processInstanceId", taskEvent.getTask().getTaskData().getProcessInstanceId());
        URL url = null;
        try {
            url = new URL("http://localhost:8089/camel/task/" + taskEvent.getTask().getId() + "/create");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            OutputStream os = con.getOutputStream();
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
                    os.flush();
        os.close();
                    int responseCode = con.getResponseCode();
            logger.info("HTTP Response Code: {}", responseCode);
        con.disconnect();



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void afterTaskExitedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskReleasedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskResumedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskSuspendedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskForwardedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskDelegatedEvent(TaskEvent taskEvent) {

    }

    public void afterTaskNominatedEvent(TaskEvent taskEvent) {

    }
}

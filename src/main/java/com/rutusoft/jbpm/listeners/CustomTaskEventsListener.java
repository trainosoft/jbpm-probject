package com.rutusoft.jbpm.listeners;

import org.json.simple.JSONObject;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import java.util.concurrent.Future;
public class CustomTaskEventsListener implements TaskLifeCycleEventListener {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomTaskEventsListener.class);
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
        System.out.println("afterTaskActivatedEvent called....");
    }

    public void afterTaskClaimedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskClaimedEvent called....");
    }

    public void afterTaskSkippedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskSkippedEvent called....");
    }

    public void afterTaskStartedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskStartedEvent called....");
    }

    public void afterTaskStoppedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskStoppedEvent called....");
    }

    public void afterTaskCompletedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskCompletedEvent called....");
    }

    public void afterTaskFailedEvent(TaskEvent taskEvent) {
        System.out.println("afterTaskFailedEvent called....");
    }

    public void afterTaskAddedEvent(TaskEvent event) {
        System.out.println("afterTaskAddedEvent called....");
        try{
            Client client = Client.create();
            AsyncWebResource webResource = client.asyncResource("http://localhost:8089/task/add");

            JSONObject jsonObject = new JSONObject();
		    jsonObject.put("taskname",event.getTask().getName());
		    jsonObject.put("pid", event.getTask().getTaskData().getProcessInstanceId());
	        jsonObject.put("taskid", event.getTask().getId());
	        jsonObject.put("assignee",event.getTask().getTaskData().getActualOwner().getId());

            logger.info("Task data : {}",event.getTask().getTaskData());

            Future<ClientResponse> response = webResource.type("application/json").post(ClientResponse.class, jsonObject.toString());
            System.out.println("response : "+response.get().getStatus());
            System.out.println("API invoked");
        }
		/*catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("jms message sent called....");
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

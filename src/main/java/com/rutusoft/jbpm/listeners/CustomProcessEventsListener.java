package com.rutusoft.jbpm.listeners;

import org.json.simple.JSONObject;
import org.kie.api.event.process.*;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import java.util.concurrent.Future;

public class CustomProcessEventsListener implements ProcessEventListener {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomProcessEventsListener.class);

    public void beforeProcessStarted(ProcessStartedEvent processStartedEvent) {
    }

    public void afterProcessStarted(ProcessStartedEvent event) {
        /*
        try{
            WorkflowProcessInstance pi = (WorkflowProcessInstance) event.getProcessInstance();
            String firstName = pi.getVariable("firstName") == null ? "" : pi.getVariable("firstName").toString();
            System.out.println("firstName : "+firstName);
            String lastName = pi.getVariable("lastName") == null ? "" : pi.getVariable("lastName").toString();
            String email = pi.getVariable("email") == null ? "" : pi.getVariable("email").toString();
            String phone = pi.getVariable("phone") == null ? "" : pi.getVariable("phone").toString();
            String accountId = pi.getVariable("accountId") == null ? "" : pi.getVariable("accountId").toString();
            String department = pi.getVariable("department") == null ? "" : pi.getVariable("department").toString();
            Boolean approvalStatus = pi.getVariable("approvalStatus") == null ? Boolean.FALSE : (Boolean) pi.getVariable("approvalStatus");

            Client client = Client.create();
            AsyncWebResource webResource = client.asyncResource("http://localhost:8089/process/start");

            JSONObject jsonObject = new JSONObject();
            KieSession kieSession = event.getKieRuntime().getKieBase().newKieSession();

            jsonObject.put("process_name",event.getProcessInstance().getProcessName());
            jsonObject.put("pid", event.getProcessInstance().getId());
            jsonObject.put("firstName", firstName);
            jsonObject.put("lastName", lastName);
            jsonObject.put("email", email);
            jsonObject.put("phone", phone);
            jsonObject.put("accountId", accountId);
            jsonObject.put("department", department);
            jsonObject.put("approvalStatus", approvalStatus);
            Future<ClientResponse> response = webResource.type("application/json").post(ClientResponse.class, jsonObject.toString());
            System.out.println("response : "+response.get().getStatus());
            System.out.println("API invoked");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         */
        System.out.println("jms message sent called....");

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

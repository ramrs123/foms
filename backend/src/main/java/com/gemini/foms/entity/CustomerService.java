package com.gemini.foms.entity;

import com.gemini.foms.entity.enums.customerservice.Service;
import com.gemini.foms.entity.enums.customerservice.ServiceStatus;

import java.time.Instant;

public class CustomerService {
    private int serviceId;
    private String customerName;
    private String checkedInRoom;
    private Service service;
    private User assignedStaff;
    private ServiceStatus status;
    private Instant createdAt;
    private Instant updatedAt;
    private String remarks;

    protected CustomerService(){};

    public CustomerService(String customerName, String checkedInRoom, Service service, ServiceStatus status) {
        this.customerName = customerName;
        this.checkedInRoom = checkedInRoom;
        this.service = service;
        this.status = ServiceStatus.CREATED;
    }

    public void assignStaff(User staff){
        if(status == ServiceStatus.CREATED){
            assignedStaff = staff;
            status = ServiceStatus.STAFF_ASSIGNED;
        } else {
            throw new RuntimeException("Cannot assign staff without a service");
        }
    }

    public void processRequest(){
        if(status == ServiceStatus.STAFF_ASSIGNED){
            status = ServiceStatus.PROCESSING;
        } else {
            throw new RuntimeException("Something went wrong");
        }
    }

    public void markServiceCompleted(){
        if(status == ServiceStatus.PROCESSING){
            status = ServiceStatus.COMPLETED;
        } else {
            throw new RuntimeException("Service is not started yet");
        }
    }
    public void markServiceCompleted(String remarks){
        if(status == ServiceStatus.PROCESSING){
            status = ServiceStatus.COMPLETED;
            this.remarks = remarks;
        } else {
            throw new RuntimeException("Service is not started yet");
        }
    }

    public void markSeviceCancel(String reason){
        if(status != ServiceStatus.COMPLETED){
            status = ServiceStatus.CANCELLED;
            remarks = reason;
        }
    }


}

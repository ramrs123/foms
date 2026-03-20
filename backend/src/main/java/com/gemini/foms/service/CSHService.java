package com.gemini.foms.service;

import com.gemini.foms.entity.CustomerServiceHistory;
import com.gemini.foms.entity.enums.customerservice.ServiceStatus;
import com.gemini.foms.repository.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CSHService {

    @Autowired
    private CustomerServiceRepository csRepository;

    public List<CustomerServiceHistory> getCustomerServiceHistoryByCustomerName(String customerName){

        return csRepository.findCustomerServiceHistoryByCustomerName(customerName);

    }

    public List<CustomerServiceHistory> getCustomerServiceHistoryByCheckedInRoom(String checkedInRoom){

        return csRepository.findCustomerServiceHistoryByCheckedInRoom(checkedInRoom);
    }

    public List<CustomerServiceHistory> getCustomerServiceHistoryByStatus(ServiceStatus status){

        return csRepository.findCustomerServiceHistoryByStatus(status);
    }
}

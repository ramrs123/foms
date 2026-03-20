package com.gemini.foms.repository;

import com.gemini.foms.entity.CustomerServiceHistory;
import com.gemini.foms.entity.enums.customerservice.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerServiceHistory, Integer> {

    @Query(value = "SELECT * FROM  CustomerServiceHistory WHERE customerName = :customerName" , nativeQuery = true)
    List<CustomerServiceHistory> findCustomerServiceHistoryByCustomerName(@Param("customerName") String customerName);

    @Query(value = "SELECT * FROM CustomerServiceHistory WHERE checkedInRoom = :checkedInRoom", nativeQuery = true)
    List<CustomerServiceHistory> findCustomerServiceHistoryByCheckedInRoom(@Param("checkedInRoom") String checkedInRoom);

    @Query(value = "SELECT * FROM CustomerServiceHistory WHERE status = :status", nativeQuery = true)
    List<CustomerServiceHistory> findCustomerServiceHistoryByStatus(@Param("status") ServiceStatus status);
}

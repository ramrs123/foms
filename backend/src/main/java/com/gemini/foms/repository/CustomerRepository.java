package com.gemini.foms.repository;

import com.gemini.foms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*
     * The custom query methods are resolved to custom sql queries by spring jpa
     * for example findByCustomerName will be resolved to a query
     * "SELECT * from customer where customername = name;"
     */
    Customer findByCustomerName(String name);

    /*
     * Or we can implement custom queries using @Query(custom_query) annotation
     */

    @Query(value = "SELECT * FROM Customers where dateOfRegister = :date", nativeQuery = true)
    List<Customer> findCustomersByDateOfRegister(@Param("date") LocalDate date);

    @Query(value = "SELECT * FROM Customers WHERE checkedInRoom = :room", nativeQuery = true)
    List<Customer> findCustomersByCheckedInRoom(@Param("room") String room);

}

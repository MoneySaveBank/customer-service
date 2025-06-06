package org.com.MSBank.customer_service.repository;

import org.com.MSBank.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> getCustomerByStatus(String status);
}

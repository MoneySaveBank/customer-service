package org.com.MSBank.customer_service.service;

import org.com.MSBank.customer_service.dto.CustomerDto;
import org.com.MSBank.customer_service.model.Customer;
import org.com.MSBank.customer_service.repository.CustomerRepository;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getCustomers();

    CustomerDto getCustomer(String customerNumber) throws Exception;

    List<CustomerDto> getCustomerByStatus(String status) throws Exception;

}

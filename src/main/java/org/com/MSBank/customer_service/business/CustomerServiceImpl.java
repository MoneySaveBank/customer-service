package org.com.MSBank.customer_service.business;

import org.com.MSBank.customer_service.dto.CustomerDto;
import org.com.MSBank.customer_service.model.Customer;
import org.com.MSBank.customer_service.repository.CustomerRepository;
import org.com.MSBank.customer_service.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final Function<Customer,CustomerDto> mapper =
            customer -> new CustomerDto(customer.getName(),customer.getLastName(),customer.getEmail());

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().stream().map(mapper).collect(Collectors.toList());

    }

    @Override
    public CustomerDto getCustomer(String customerNumber) throws Exception {
        return mapper.apply(customerRepository.findById(customerNumber).orElseThrow(() ->
                new Exception("Customer not found")));
    }

    @Override
    public List<CustomerDto> getCustomerByStatus(String status) throws Exception{
        return customerRepository.getCustomerByStatus(status).stream().map(mapper).collect(Collectors.toList());
    }
}

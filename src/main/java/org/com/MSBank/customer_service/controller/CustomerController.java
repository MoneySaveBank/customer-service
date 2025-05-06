package org.com.MSBank.customer_service.controller;

import org.com.MSBank.customer_service.dto.CustomerDto;
import org.com.MSBank.customer_service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> customersDto = customerService.getCustomers();
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String customerNumber) throws Exception {
        CustomerDto customerDto = customerService.getCustomer(customerNumber);
        return new ResponseEntity<>(customerDto,HttpStatus.OK);
    }

    @GetMapping("/searchby")
    public ResponseEntity<List<CustomerDto>> getCustomerByStatus(@RequestParam String status) throws Exception {
        return new ResponseEntity<>(customerService.getCustomerByStatus(status),HttpStatus.OK);
    }

}

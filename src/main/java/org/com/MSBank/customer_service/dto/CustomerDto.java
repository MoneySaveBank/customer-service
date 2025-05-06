package org.com.MSBank.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private String name;
    private String lastName;
    private String email;
}

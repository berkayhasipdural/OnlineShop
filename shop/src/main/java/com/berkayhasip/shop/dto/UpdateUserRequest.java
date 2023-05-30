package com.berkayhasip.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class UpdateUserRequest {

    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

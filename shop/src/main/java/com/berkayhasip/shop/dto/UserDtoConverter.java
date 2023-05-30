package com.berkayhasip.shop.dto;

import com.berkayhasip.shop.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
        return new UserDto(from.getEmail() , from.getFirstName() , from.getLastName());
    }
}

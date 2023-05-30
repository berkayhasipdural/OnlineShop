package com.berkayhasip.shop.user.service;

import com.berkayhasip.shop.dto.CreateUserRequest;
import com.berkayhasip.shop.dto.UpdateUserRequest;
import com.berkayhasip.shop.dto.UserDto;
import com.berkayhasip.shop.dto.UserDtoConverter;
import com.berkayhasip.shop.excepiton.UserNotFoundException;
import com.berkayhasip.shop.user.model.User;
import com.berkayhasip.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDtoConverter userDtoConverter;

    private final UpdateUserRequest updateUserRequest;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserDtoConverter userDtoConverter, UpdateUserRequest updateUserRequest , UserRepository userRepository) {
        this.userDtoConverter = userDtoConverter;
        this.userRepository = userRepository;
        this.updateUserRequest = updateUserRequest;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public User getUserById(Long id){
        User user = findUserById(id);
        User updatedUser = new User(user.getId() , updateUserRequest.getFirstName() , updateUserRequest.getLastName());
        return user;
    }

    public  UserDto createUser(CreateUserRequest userRequest){
        User user = new User(userRequest.getEmail() , userRequest.getFirstName() , userRequest . getLastName());
        return userDtoConverter.convert(userRepository.save(user));
    }
    public UserDto updateUser(Long id , UpdateUserRequest updateUserRequest){
        User user = findUserById(id);
        User updateUser = new User(user.getId(),user.getEmail(), updateUserRequest.getFirstName() , updateUserRequest.getLastName());
        return userDtoConverter.convert(userRepository.save(updateUser));
    }
    protected User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User couldn't be found id : "+ id));
    }
}

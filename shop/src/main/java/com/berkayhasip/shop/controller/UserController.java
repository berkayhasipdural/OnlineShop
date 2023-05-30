package com.berkayhasip.shop.controller;

import com.berkayhasip.shop.dto.CreateUserRequest;
import com.berkayhasip.shop.dto.UpdateUserRequest;
import com.berkayhasip.shop.dto.UserDto;
import com.berkayhasip.shop.user.model.User;
import com.berkayhasip.shop.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }
/*    @PatchMapping("/{id}")
    public ResponseEntity deactivateUser(@PathVariable("id")Long id){
        userService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }*/


}

package com.ecommerce.UserDetails.controller;

import com.ecommerce.UserDetails.Service.UserServiceInterface;
import com.ecommerce.UserDetails.dto.UserRequest;
import com.ecommerce.UserDetails.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {
    private UserServiceInterface userService;
    @GetMapping("/Get")
    public ResponseEntity<List<UserResponse>> get(){
        List<UserResponse> userList = userService.getUserList();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserRequest> create(@RequestBody UserRequest userRequest){
        UserRequest savedUser = userService.createUser(userRequest);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest ,@PathVariable("id") int id){
        UserResponse updateUser = userService.updateUser(userRequest,id);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<HttpStatus> delete(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

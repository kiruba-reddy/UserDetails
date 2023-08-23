package com.ecommerce.UserDetails.Service;

import com.ecommerce.UserDetails.dto.UserRequest;
import com.ecommerce.UserDetails.dto.UserResponse;

import java.util.List;

public interface UserServiceInterface {
    List<UserResponse> getUserList();
    UserRequest createUser(UserRequest user);
    UserResponse updateUser(UserRequest user,int id);
    void deleteUser(int id);
}

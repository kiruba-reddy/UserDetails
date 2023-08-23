package com.ecommerce.UserDetails.Mapper;

import com.ecommerce.UserDetails.dto.UserRequest;
import com.ecommerce.UserDetails.dto.UserResponse;
import com.ecommerce.UserDetails.model.User;

public class UserMapper {
    public static UserRequest mapUserRequestToUser(User user){
        return new UserRequest(
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
    public static User mapUserToUserRequest(UserRequest user){
        return User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
    public static UserResponse mapUserResponseToUser(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
    public static User mapUserToUserResponse(UserResponse user){
        return new User(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}

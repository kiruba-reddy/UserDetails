package com.ecommerce.UserDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int Id;
    private String name;
    private String email;
    private String phone;
}

package com.example.irctc.Transformer;

import com.example.irctc.DTO.Request.UserRequest;
import com.example.irctc.DTO.Response.UserResponse;
import com.example.irctc.Entity.User;
import com.example.irctc.Enum.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    @Autowired
    PasswordEncoder passwordEncoder;
    public User userRequestToUser(UserRequest userRequest)
    {
        User user=User.builder().
                username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(Role.ROLE_USER).build();
        return user;
    }

    public UserResponse userToUserResponse(User user)
    {
        UserResponse userResponse= UserResponse.builder().
                username(user.getUsername())
                .role(user.getRole())
                .bookingList(user.getBookings())
                .build();
        return userResponse;
    }
}

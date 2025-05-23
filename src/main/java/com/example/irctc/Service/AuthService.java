package com.example.irctc.Service;

import com.example.irctc.DTO.Request.AuthRequest;
import com.example.irctc.DTO.Request.UserRequest;
import com.example.irctc.DTO.Response.UserResponse;

public interface AuthService {
    public UserResponse registerUser(UserRequest request);
    public String login(AuthRequest request);
}

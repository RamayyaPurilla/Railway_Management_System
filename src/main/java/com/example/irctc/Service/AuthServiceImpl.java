package com.example.irctc.Service;

import com.example.irctc.DTO.Request.AuthRequest;
import com.example.irctc.DTO.Request.UserRequest;
import com.example.irctc.DTO.Response.UserResponse;
import com.example.irctc.Entity.User;
import com.example.irctc.Repository.UserRepository;
import com.example.irctc.Security.JwtUtil;
import com.example.irctc.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserTransformer userTransformer;
    @Override
    public UserResponse registerUser(UserRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
        {
            throw new RuntimeException("UserName already exist");
        }
        User user=userTransformer.userRequestToUser(request);
        User user1=userRepository.save(user);
        UserResponse userResponse=userTransformer.userToUserResponse(user1);
        return userResponse;
    }

    public String login(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }

        // Generate JWT token
        return jwtUtil.generateToken(request.getUsername());
    }
}

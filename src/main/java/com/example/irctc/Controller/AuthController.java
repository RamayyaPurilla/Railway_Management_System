package com.example.irctc.Controller;

import com.example.irctc.DTO.Request.AuthRequest;
import com.example.irctc.DTO.Request.UserRequest;
import com.example.irctc.DTO.Response.UserResponse;
import com.example.irctc.Service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
//@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;    //check exceptions


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        UserResponse userResponse=authService.registerUser(request);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        String token = authService.login(request);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }


}

package com.shtven.autentication.Controller;

import com.shtven.autentication.DTO.Request.Login;
import com.shtven.autentication.DTO.Request.UserRequest;
import com.shtven.autentication.Model.CodeOTP;
import com.shtven.autentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserRequest user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody Login login) {
        userService.loginUser(login);
        return ResponseEntity.ok("User logged in successfully");
    }
}

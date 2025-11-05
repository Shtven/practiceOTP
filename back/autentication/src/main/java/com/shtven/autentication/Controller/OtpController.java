package com.shtven.autentication.Controller;

import com.shtven.autentication.DTO.Request.OtpValidationRequest;
import com.shtven.autentication.Model.User;
import com.shtven.autentication.Repository.UserRepository;
import com.shtven.autentication.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpValidationRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        boolean valid = otpService.verifyOtp(user.get().getEmail(), request.getCode());
        if (valid) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired OTP");
        }
    }
}


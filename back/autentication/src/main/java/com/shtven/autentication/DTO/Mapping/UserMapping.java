package com.shtven.autentication.DTO.Mapping;

import com.shtven.autentication.Configuration.SecurityConfig;
import com.shtven.autentication.DTO.Request.UserRequest;
import com.shtven.autentication.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User mapToEntity(UserRequest userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return user;
    }
}

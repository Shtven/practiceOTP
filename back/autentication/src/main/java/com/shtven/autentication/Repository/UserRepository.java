package com.shtven.autentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shtven.autentication.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

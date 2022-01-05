package com.example.testspring.repository;

import com.example.testspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}

package com.example.backend_RestAPI.repository;

import com.example.backend_RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

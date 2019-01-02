package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.O2O.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

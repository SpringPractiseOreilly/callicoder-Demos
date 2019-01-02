package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.O2O.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}

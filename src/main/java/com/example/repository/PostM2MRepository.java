package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.M2M.PostM2M;

public interface PostM2MRepository extends JpaRepository<PostM2M, Long> {

}

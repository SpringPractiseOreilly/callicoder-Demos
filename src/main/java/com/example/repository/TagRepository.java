package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.M2M.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}

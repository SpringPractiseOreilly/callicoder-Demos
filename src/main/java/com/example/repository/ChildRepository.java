package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.elementCollection.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

}

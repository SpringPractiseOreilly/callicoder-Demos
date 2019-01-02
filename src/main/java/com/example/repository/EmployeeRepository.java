package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CompositeKeys.Employee;
import com.example.model.CompositeKeys.EmployeeIdentity;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {

	List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}

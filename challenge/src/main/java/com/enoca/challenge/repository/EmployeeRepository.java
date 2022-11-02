package com.enoca.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findAllByCompanyId(Long companyId);
}

package com.enoca.challenge.service;

import java.util.List;

import com.enoca.challenge.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(Long companyId, EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long id);

	List<EmployeeDto> getAllEmployeesByCompanyId(Long companyId);

	void deleteEmployeeById(Long id);

	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

}

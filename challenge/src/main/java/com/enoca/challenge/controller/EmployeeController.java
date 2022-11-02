package com.enoca.challenge.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.dto.CompanyDto;
import com.enoca.challenge.dto.EmployeeDto;
import com.enoca.challenge.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@PostMapping("/{companyId}")
	public ResponseEntity<EmployeeDto> createEmployee(@PathVariable Long companyId, @RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.createEmployee(companyId, employeeDto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	@GetMapping("/allEmployees/{companyId}")
	public List<EmployeeDto> getAllEmployeesByCompanyId(@PathVariable Long companyId){
		return employeeService.getAllEmployeesByCompanyId(companyId);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>("Employee deleted successfully!", HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable Long id,@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.updateEmployee(id,employeeDto),HttpStatus.OK);
	}
	
}

package com.enoca.challenge.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.enoca.challenge.dto.CompanyDto;
import com.enoca.challenge.dto.EmployeeDto;
import com.enoca.challenge.entity.Company;
import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.exception.ResourseNotFoundException;
import com.enoca.challenge.repository.EmployeeRepository;
import com.enoca.challenge.service.CompanyService;
import com.enoca.challenge.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	
	private final CompanyService companyService;
	
	private final ModelMapper modelMapper;
	
	@Override
	public EmployeeDto createEmployee(Long companyId, EmployeeDto employeeDto) {
		Company company = modelMapper.map(companyService.getCompanyById(companyId), Company.class);
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		employee.setCompany(company);
		employeeRepository.save(employee);
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Employee not found with id!"));
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployeesByCompanyId(Long companyId) {
		List<Employee> employees = employeeRepository.findAllByCompanyId(companyId);
		return employees.stream().map(employee->modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Employee not found with id!"));
		employeeRepository.delete(employee);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Employee not found with id!"));
		employee.setName(employeeDto.getName());
		employee.setPosition(employeeDto.getPosition());
		employeeRepository.save(employee);
		return modelMapper.map(employee, EmployeeDto.class);
	}

}

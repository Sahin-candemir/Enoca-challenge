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
import com.enoca.challenge.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping
	public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){
		return new ResponseEntity<>(companyService.createCompany(companyDto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
		return new ResponseEntity<>(companyService.getCompanyById(id),HttpStatus.OK);
	}
	@GetMapping
	public List<CompanyDto> getAllCompany(){
		return companyService.getAllCompany();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
		companyService.deleteCompanyById(id);
		return new ResponseEntity<>("Company deleted successfully!", HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> updateCompany( @PathVariable Long id,@RequestBody CompanyDto companyDto){
		return new ResponseEntity<>(companyService.updateCompany(id,companyDto),HttpStatus.OK);
	}
}

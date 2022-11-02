package com.enoca.challenge.service;

import java.util.List;

import com.enoca.challenge.dto.CompanyDto;

public interface CompanyService {

	CompanyDto createCompany(CompanyDto companyDto);

	CompanyDto getCompanyById(Long id);

	List<CompanyDto> getAllCompany();

	void deleteCompanyById(Long id);

	CompanyDto updateCompany(Long id, CompanyDto companyDto);

}

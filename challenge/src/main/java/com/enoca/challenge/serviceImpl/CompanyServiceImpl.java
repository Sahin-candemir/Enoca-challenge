package com.enoca.challenge.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.enoca.challenge.dto.CompanyDto;
import com.enoca.challenge.entity.Company;
import com.enoca.challenge.exception.ResourseNotFoundException;
import com.enoca.challenge.repository.CompanyRepository;
import com.enoca.challenge.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

	private final CompanyRepository companyRepository;
	
	private final ModelMapper modelMapper;
	
	@Override
	public CompanyDto createCompany(CompanyDto companyDto) {
		Company company = modelMapper.map(companyDto, Company.class);
		companyRepository.save(company);
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public CompanyDto getCompanyById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Company not found with id!"));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllCompany() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(company->modelMapper.map(company, CompanyDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteCompanyById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Company not found with id!"));
		
		companyRepository.delete(company);
	}

	@Override
	public CompanyDto updateCompany(Long id, CompanyDto companyDto) {
		Company company = companyRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Company not found with id!"));
		company.setName(companyDto.getName());
		companyRepository.save(company);
		return modelMapper.map(company, CompanyDto.class);
	}

}

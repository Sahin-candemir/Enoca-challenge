package com.enoca.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}

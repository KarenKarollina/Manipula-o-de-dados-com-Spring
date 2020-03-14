package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;

@Service
public class CompanyService implements CompanyServiceInterface{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company save(Company object) {
		return companyRepository.save((Company) object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return (List<Company>) companyRepository.findByAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return (List<Company>) companyRepository.findByUserId(userId);
	}	
	}
	
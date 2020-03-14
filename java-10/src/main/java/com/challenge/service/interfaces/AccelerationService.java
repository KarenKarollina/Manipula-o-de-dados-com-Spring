package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;

@Service
public class AccelerationService implements AccelerationServiceInterface{

	@Autowired
	private AccelerationRepository accelerationRepository;

	@Override
	public Acceleration save(Acceleration object) {
		
		return accelerationRepository.save((Acceleration) object);
	}

	@Override
	public Optional<Acceleration> findById(Long id) {
		
		return accelerationRepository.findById(id);
	}

	@Override
	public List<Acceleration> findByCompanyId(Long companyId) {
		
		return (List<Acceleration>) accelerationRepository.findByCompanyId(companyId);
	}
}

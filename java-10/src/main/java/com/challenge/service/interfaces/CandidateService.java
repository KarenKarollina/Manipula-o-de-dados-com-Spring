package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;

@Service
public class CandidateService implements CandidateServiceInterface {
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public Candidate save(Candidate object) {
		
		return candidateRepository.save((Candidate) object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		
		return candidateRepository.findByCandidateId(id);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		
		return candidateRepository.findByAccelerationIdd(accelerationId);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		
		return (List<Candidate>) candidateRepository.findByCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		
		return candidateRepository.findByAccelerationId(accelerationId);
	}
	
	

}

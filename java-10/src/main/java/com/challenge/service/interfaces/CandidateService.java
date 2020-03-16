package com.challenge.service.interfaces;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate save(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    @Override
    public Optional<Candidate> findById(CandidateId id){
        return candidateRepository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId){
        return candidateRepository.findById(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId){
        return candidateRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId){
        return candidateRepository.findByAccelerationId(accelerationId);
    }
}

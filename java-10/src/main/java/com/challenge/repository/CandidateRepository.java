package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	Candidate findByCompanyId(long companyId);
	List<Candidate> findByAccelerationId(long accelerationId);
	Optional<Candidate> findByCandidateId(CandidateId id);
	Optional<Candidate> findByAccelerationIdd(long accelerationId);


}

package com.challenge.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.entity.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
	
	BigDecimal findHigherScoreByChallengeId(long challengeId);
	Submission findByChallengeIdAndAccelerationId(long challengeId, long accelerationId);
	
}

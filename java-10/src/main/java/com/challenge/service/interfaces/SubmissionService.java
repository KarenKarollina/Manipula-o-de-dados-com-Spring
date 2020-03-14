package com.challenge.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;

@Service
public class SubmissionService implements SubmissionServiceInterface {

	private SubmissionRepository submissionRepository;

	@Override
	public Submission save(Submission object) {
		return submissionRepository.save((Submission) object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		return submissionRepository.findHigherScoreByChallengeId(challengeId);
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return (List<Submission>) submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}
}
	
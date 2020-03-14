package com.challenge.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;

@Service
public class ChallengeService implements ChallengeServiceInterface {
	
	@Autowired
	private ChallengeRepository challengeRepository;

	@Override
	public Challenge save(Challenge object) {
		return challengeRepository.save((Challenge) object);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return (List<Challenge>) challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
	}
	
	
}

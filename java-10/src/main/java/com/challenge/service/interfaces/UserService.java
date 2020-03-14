package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{

	private UserRepository userRepository;

	@Override
	public User save(User object) {
		return userRepository.save((User) object);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return (List<User>) userRepository.findByAccelerationName(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return (List<User>) userRepository.findByCompanyId(companyId);
	}
	
}

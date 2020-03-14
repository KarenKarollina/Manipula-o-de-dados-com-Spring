package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id);
	User findByAccelerationName(String accelerationName);
	User findByCompanyId(long companyId);
	

}

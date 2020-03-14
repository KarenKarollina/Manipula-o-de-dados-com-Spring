package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {
	
	Acceleration findAccelerationById(long id);
	Acceleration findAccelerationByName(String name);
	Acceleration findByCompanyId(long companyId);
	

}

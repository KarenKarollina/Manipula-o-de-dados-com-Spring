package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company findById(long id);

    @Query(value = "SELECT distinct comp.* FROM Company comp " +
            "INNER JOIN Candidate ca " +
            "ON ca.company_id = comp.id " +
            "INNER JOIN Acceleration acc " +
            "ON ca.acceleration_id = acc.id AND acc.id = :accelerationId",
            nativeQuery = true)
    List<Company> findByAccelerationId(Long accelerationId);


    @Query(value = "SELECT comp.* FROM Company comp " +
            "INNER JOIN Candidate ca " +
            "ON ca.company_id = comp.id  " +
            "INNER JOIN users u " +
            "ON ca.user_id = u.id AND u.id = :userId",
            nativeQuery = true)
    List<Company> findByUserId(Long userId);
}
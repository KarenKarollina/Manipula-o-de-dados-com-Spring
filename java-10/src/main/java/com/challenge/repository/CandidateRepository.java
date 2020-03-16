package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    Optional<Candidate> findById(CandidateId id);


    @Query(value = "SELECT ca.* FROM Candidate ca " +
            "WHERE ca.user_id = :userId " +
            "AND ca.company_id = :companyId " +
            "AND ca.acceleration_id = :accelerationId ",
            nativeQuery = true)
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);


    @Query(value = "SELECT ca.* FROM Candidate ca " +
            "WHERE ca.company_id = :companyId",
            nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT ca.* FROM Candidate ca " +
            "WHERE ca.acceleration_id = :accelerationId",
            nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
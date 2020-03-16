package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration,Long> {

    Acceleration findById(long id);

    @Query(value = "SELECT acc.* FROM Acceleration acc " +
            "INNER JOIN Candidate ca " +
            "ON acc.id = ca.acceleration_id " +
            "INNER JOIN Company comp " +
            "ON comp.id = ca.company_id AND comp.id = :companyId",
            nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

}
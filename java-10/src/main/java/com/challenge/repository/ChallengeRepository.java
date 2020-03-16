package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge,Long> {

    @Query(value = "SELECT distinct cha.* FROM Challenge cha " +
            "INNER JOIN Acceleration acc " +
            "ON cha.id = acc.challenge_id AND acc.id = :accelerationId " +
            "INNER JOIN Candidate ca " +
            "ON acc.id = ca.acceleration_id " +
            "INNER JOIN users u " +
            "ON ca.user_id = u.id AND u.id = :userId ",
            nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
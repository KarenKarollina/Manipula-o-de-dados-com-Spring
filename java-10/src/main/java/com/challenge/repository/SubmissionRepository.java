package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {

    @Query(value = " SELECT max(s.score) FROM Submission s " +
            " INNER JOIN Challenge cha " +
            " ON s.challenge_id = cha.id AND cha.id = :challengeId ",
            nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);


    @Query(value = " SELECT s.* FROM Submission s " +
            " INNER JOIN Challenge cha " +
            " ON s.challenge_id = cha.id AND cha.id = :challengeId " +
            " INNER JOIN Acceleration acc " +
            " ON acc.challenge_id = cha.id AND acc.id = :accelerationId ",
            nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}

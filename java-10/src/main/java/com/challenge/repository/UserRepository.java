package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findById(long id);

    @Query(value = "SELECT u.* FROM users u " +
            "INNER JOIN Candidate ca " +
            "ON ca.user_id = u.id " +
            "INNER JOIN Acceleration acc " +
            "ON ca.acceleration_id = acc.id AND acc.name = :name ",
            nativeQuery = true)
    List<User> findByAccelerationName(String name);

    @Query(value = "SELECT u.* FROM users u " +
            "INNER JOIN Candidate ca " +
            "ON ca.user_id = u.id " +
            "INNER JOIN Company comp " +
            "ON ca.company_id = comp.id AND comp.id = :companyId",
            nativeQuery = true)
    List<User> findByCompanyId(Long companyId);

}

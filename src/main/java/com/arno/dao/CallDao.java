package com.arno.dao;

import com.arno.domain.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CallDao extends JpaRepository<Call,Integer> {

    @Query(value = "SELECT * FROM call c WHERE c.user_id =:user_id", nativeQuery = true)
    List<Call> getAllForUser(@Param("user_id") int userId);
}

package com.arno.dao;

import com.arno.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenDao extends JpaRepository<Token,Integer> {

    @Query(value = "SELECT * FROM token t WHERE t.value =:value", nativeQuery = true)
    Token getTokenByValue(@Param("value") String value);

    @Query(value = "SELECT * FROM token t WHERE t.id =:id", nativeQuery = true)
    Token getTokenById(@Param("id") int id);
}

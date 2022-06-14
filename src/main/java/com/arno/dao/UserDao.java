package com.arno.dao;

import com.arno.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user u WHERE u.login = :login and u.password = :password", nativeQuery = true)
    User getByLoginAndPassword(@Param("login") String login, @Param("password") String password );
}

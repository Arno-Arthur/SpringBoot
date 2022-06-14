package com.arno.dao;

import com.arno.domain.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryDao extends JpaRepository<Registry,Integer> {
}

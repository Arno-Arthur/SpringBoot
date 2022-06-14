package com.arno.dao;

import com.arno.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationDao extends JpaRepository<Organization,Integer> {
}

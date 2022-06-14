package com.arno.dao;

import com.arno.domain.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeoPointDao extends JpaRepository<GeoPoint,Integer> {

    @Query(value = "SELECT * FROM geo_point g WHERE g.call_id =:id LIMIT 1", nativeQuery = true)
    GeoPoint getGeoPointByCallId(@Param("id") int id);
}

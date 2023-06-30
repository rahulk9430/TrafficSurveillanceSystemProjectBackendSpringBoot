package com.sopra.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.entity.Road;
import com.sopra.entity.TrafficData;

import jakarta.transaction.Transactional;

@Repository
public interface TrafficDataRepo extends JpaRepository<TrafficData, Long> {
	@Modifying
    @Transactional
	@Query("DELETE FROM TrafficData td WHERE td.trafficDataId.date < :date")
	void deleteByDateLessThan(@Param("date") Date date);
	

}

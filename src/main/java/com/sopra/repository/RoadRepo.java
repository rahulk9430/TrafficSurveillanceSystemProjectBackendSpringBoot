package com.sopra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.entity.Road;

@Repository
public interface RoadRepo extends JpaRepository<Road, Integer> {

}

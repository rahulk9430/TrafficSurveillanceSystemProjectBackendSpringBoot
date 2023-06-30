package com.sopra.service;

import java.util.List;

import com.sopra.entity.Road;

public interface RoadService {
	
	Road addRoad(Road road);
	
	Road updateRoad(Integer id,Road road);
	
	List<Road> getAllRoads();
	
	Road getRoadById(Integer id);
	
	 void deleteRoad(Integer id);
	
}

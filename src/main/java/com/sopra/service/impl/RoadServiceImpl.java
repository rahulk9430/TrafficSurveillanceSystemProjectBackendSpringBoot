package com.sopra.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.entity.Road;
import com.sopra.exception.ResourceNotFoundException;
import com.sopra.repository.RoadRepo;
import com.sopra.service.RoadService;

@Service
public class RoadServiceImpl implements RoadService{
	
	@Autowired
	private RoadRepo roadRepo;

	@Override
	public Road addRoad(Road road) {
		
		Road save = this.roadRepo.save(road);
		
		return save;
	}

	@Override
	    public Road updateRoad(Integer id,Road road) {
		
		Road findById = this.roadRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("This Road is","ID",id));
		
		findById.setDetectorName(road.getDetectorName());
		findById.setRoadName(road.getRoadName());
		findById.setDetectorStatus(road.isDetectorStatus());
		
		return roadRepo.save(findById);
		
	}

	@Override
	public List<Road> getAllRoads() {
		
		List<Road> findAll = this.roadRepo.findAll();
		return findAll;
	}

	@Override
	public Road getRoadById(Integer id) {
		
		Road findById = this.roadRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("This Road is","ID",id));
		return findById;
	}

	@Override
	public void deleteRoad(Integer id) {
		Road findById = this.roadRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("This Road is","ID",id));
		this.roadRepo.delete(findById);
		
	}

}

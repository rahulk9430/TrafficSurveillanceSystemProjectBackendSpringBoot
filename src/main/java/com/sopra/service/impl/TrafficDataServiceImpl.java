package com.sopra.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sopra.entity.Road;
import com.sopra.entity.TrafficData;
import com.sopra.repository.RoadRepo;
import com.sopra.repository.TrafficDataRepo;
import com.sopra.service.TrafficDataService;

@Service
public class TrafficDataServiceImpl implements TrafficDataService {
	
	@Autowired
	private TrafficDataRepo trafficDataRepo;



	@Override
	public List<TrafficData> getAllTrafficData() {
		
		  List<TrafficData> trafficData=new ArrayList<>();
		  trafficDataRepo.findAll(Sort.by(Sort.Direction.DESC,"TrafficDataId.date")).forEach(trafficData::add);
		  return trafficData;
	}


	


	
	
}

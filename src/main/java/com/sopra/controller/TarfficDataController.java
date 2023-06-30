package com.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dto.DtoHelper;
import com.sopra.dto.TrafficDataDto;
import com.sopra.entity.TrafficData;
import com.sopra.service.TrafficDataService;


@RestController
@RequestMapping("/traffic")
@CrossOrigin
public class TarfficDataController {
	
	@Autowired
	private TrafficDataService trafficDataService;
	
	@GetMapping("/")
	public List<TrafficDataDto> getAllTrafficdata(){
		
		return DtoHelper.getTrafficDataDto(trafficDataService.getAllTrafficData());
		
		
	}
	
	

}

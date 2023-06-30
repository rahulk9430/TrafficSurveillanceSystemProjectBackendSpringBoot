package com.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sopra.entity.Road;
import com.sopra.service.RoadService;

@RestController
@RequestMapping("/road")
@CrossOrigin
public class RoadController {
	
	@Autowired
	private RoadService roadService;
	
	@PostMapping("/")
	public Road addRoad(@RequestBody Road road) {
		Road addRoad = this.roadService.addRoad(road);
		return addRoad;
	}
	@PutMapping("/{id}")
	public Road updateRoad(@RequestBody Road road,@PathVariable Integer id) {
		Road updateRoad = this.roadService.updateRoad(id,road);
		return updateRoad;
	}
	@DeleteMapping("/{id}")
	public void deleteRoad(@PathVariable Integer id) {
		this.roadService.deleteRoad(id);
	}

	@GetMapping("/")
	public List<Road> getAllRoads(){
		List<Road> allRoads = this.roadService.getAllRoads();
		return allRoads;
	}
	@GetMapping("/{id}")
	public Road getRoads(@PathVariable Integer id) {
		Road roadById = this.roadService.getRoadById(id);
		return roadById;
	}
}

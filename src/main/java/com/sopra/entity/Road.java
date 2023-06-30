package com.sopra.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ROAD", uniqueConstraints = @UniqueConstraint(columnNames = {"DETECTOR_NAME", "ROAD_NAME"}))
public class Road {
	//private static final long serialVersionUID = -4178142122432290069L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "road_id")
	private int roadId;
	
	@Column(name = "road_name")
	private String roadName;
	
	@Column(name="detector_name")
	private String detectorName;
	
	@Column(name = "detector_status")
	private boolean detectorStatus;
	

	
	public int getRoadId() {
		return roadId;
	}

	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}

	public Road(int roadId, String roadName, String detectorName, boolean detectorStatus,
			List<TrafficData> trafficData) {
		super();
		this.roadId = roadId;
		this.roadName = roadName;
		this.detectorName = detectorName;
		this.detectorStatus = detectorStatus;
	
	}


	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getDetectorName() {
		return detectorName;
	}

	public void setDetectorName(String detectorName) {
		this.detectorName = detectorName;
	}

	public boolean isDetectorStatus() {
		return detectorStatus;
	}

	public void setDetectorStatus(boolean detectorStatus) {
		this.detectorStatus = detectorStatus;
	}

	public Road(int roadId, String roadName, String detectorName, boolean detectorStatus) {
		super();
		this.roadId = roadId;
		this.roadName = roadName;
		this.detectorName = detectorName;
		this.detectorStatus = detectorStatus;
	}

	public Road() {
		
	}
	
	

	
}

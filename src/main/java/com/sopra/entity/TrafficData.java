package com.sopra.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRAFFIC_DATA")
public class TrafficData{

	private static final long serialVersionUID = 3309792050686058989L;
	@EmbeddedId
	private TrafficDataId trafficDataId;

	private Double occupancyPercentage;
	private Double averageSpeed;
	private Integer classOneVolume;
	private Integer classTwoVolume;
	private Integer classThreeVolume;
	private Integer volume;

	private Integer period;
	private CongestionLevel congestionLevel = CongestionLevel.NORMAL;

	public TrafficDataId getTrafficDataId() {
		return trafficDataId;
	}

	public void setTrafficDataId(TrafficDataId trafficDataId) {
		this.trafficDataId = trafficDataId;
	}

	public Double getOccupancyPercentage() {
		return occupancyPercentage;
	}

	public void setOccupancyPercentage(Double occupancyPercentage) {
		this.occupancyPercentage = occupancyPercentage;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public int getClassOneVolume() {
		return classOneVolume;
	}

	public void setClassOneVolume(int classOneVolume) {
		this.classOneVolume = classOneVolume;
	}

	public int getClassTwoVolume() {
		return classTwoVolume;
	}

	public void setClassTwoVolume(int classTwoVolume) {
		this.classTwoVolume = classTwoVolume;
	}

	public int getClassThreeVolume() {
		return classThreeVolume;
	}

	public void setClassThreeVolume(int classThreeVolume) {
		this.classThreeVolume = classThreeVolume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public CongestionLevel getCongestionLevel() {
		return congestionLevel;
	}

	public void setCongestionLevel(CongestionLevel congestionLevel) {
		this.congestionLevel = congestionLevel;
	}

	@Override
	public String toString() {
		return "TrafficData [trafficDataId=" + trafficDataId + ", occupancyPercentage=" + occupancyPercentage
				+ ", averageSpeed=" + averageSpeed + ", classOneVolume=" + classOneVolume + ", classTwoVolume="
				+ classTwoVolume + ", classThreeVolume=" + classThreeVolume + ", volume=" + volume + ", period="
				+ period + ", congestionLevel=" + congestionLevel + "]";
	}

	public TrafficData(TrafficDataId trafficDataId, Double occupancyPercentage, Double averageSpeed, int classOneVolume,
			int classTwoVolume, int classThreeVolume, int volume, int period, CongestionLevel congestionLevel) {
		super();
		this.trafficDataId = trafficDataId;
		this.occupancyPercentage = occupancyPercentage;
		this.averageSpeed = averageSpeed;
		this.classOneVolume = classOneVolume;
		this.classTwoVolume = classTwoVolume;
		this.classThreeVolume = classThreeVolume;
		this.volume = volume;
		this.period = period;
		this.congestionLevel = congestionLevel;
	}

	public TrafficData() {
		super();
	}

}

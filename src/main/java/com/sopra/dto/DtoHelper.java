package com.sopra.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.sopra.entity.TrafficData;
import com.sopra.entity.TrafficDataId;

public class DtoHelper {
	
	public static List<TrafficDataDto> getTrafficDataDto(List<TrafficData> trafficDataList){
		
		List<TrafficDataDto> trafficDataDtoList= new ArrayList<>();
		
		if(!CollectionUtils.isEmpty(trafficDataList)) {
			trafficDataList.stream().forEach(trafficData->trafficDataDtoList.add(getTrafficDataDto(trafficData)));
		}
		return trafficDataDtoList;
		
	}
	
	public static TrafficDataDto getTrafficDataDto(TrafficData trafficData) {
		TrafficDataDto trafficDataDto=null;
		
		if(trafficData!=null){
			trafficDataDto =new TrafficDataDto();
			
			trafficDataDto.setRoadName(trafficData.getTrafficDataId().getRoadName());
			trafficDataDto.setDetectorName(trafficData.getTrafficDataId().getDetectorName());
			trafficDataDto.setAverageSpeed(trafficData.getAverageSpeed());
			trafficDataDto.setClassOneVolume(trafficData.getClassOneVolume());
			trafficDataDto.setClassTwoVolume(trafficData.getClassTwoVolume());
			trafficDataDto.setClassThreeVolume(trafficData.getClassThreeVolume());
			trafficDataDto.setOccupancyPercentage(trafficData.getOccupancyPercentage());
			trafficDataDto.setPeriod(20);
			trafficDataDto.setVolume(trafficData.getVolume());
			trafficDataDto.setDate(trafficData.getTrafficDataId().getDate());
			trafficDataDto.setCongestionLevel(trafficData.getCongestionLevel().getValue());;
		}
		
		return trafficDataDto;
	}

}

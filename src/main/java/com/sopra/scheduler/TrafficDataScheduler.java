package com.sopra.scheduler;

import com.sopra.entity.CongestionLevel;
import com.sopra.entity.Road;
import com.sopra.entity.TrafficData;
import com.sopra.entity.TrafficDataId;
import com.sopra.repository.RoadRepo;
import com.sopra.repository.TrafficDataRepo;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component
public class TrafficDataScheduler {

	private final int MAX_VOLUME = 30;

	@Autowired
	private RoadRepo roadRepo;
	@Autowired
	private TrafficDataRepo trafficDataRepo;

	@PostConstruct
	public void start() { // This line defines the start() method, which is responsible for starting the
							// scheduler.
		
		Timer timer = new Timer(); // Creates a new instance of the Timer class, which allows scheduling tasks to
									// be executed at specified intervals.
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				generateTrafficData();
			}
		}, 0, 20000); // Execute every 20 seco nds

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				deleteOldData();
			}
		}, 0, 18000); // Execute every 5 min
	}

	private void generateTrafficData() {
		Random random = new Random();
		Date now = new Date();
		List<TrafficData> trafficDataList = new ArrayList<>();
		try {
			List<Road> roads = roadRepo.findAll();
			if (!CollectionUtils.isEmpty(roads)) {
				roads.stream().filter(Road::isDetectorStatus).forEach(road -> {
					TrafficDataId trafficDataId = new TrafficDataId(road.getDetectorName(), road.getRoadName(), now);

					int classOneVolume = random.nextInt(9) + 1;
					int classTwoVolume = random.nextInt(9) + 1;
					int classThreeVolume = random.nextInt(9) + 1;
					double averageSpeed = random.nextInt(90) + 10.0;

					int volume = classOneVolume + classTwoVolume + classThreeVolume;
					double occupancyPercentage = calculateOccupancyPercentage(volume);
					CongestionLevel congestionLevel = calculateCongestionLevel(occupancyPercentage);

					TrafficData trafficData = new TrafficData();

					trafficData.setTrafficDataId(trafficDataId);
					trafficData.setAverageSpeed(averageSpeed);
					trafficData.setClassOneVolume(classOneVolume);
					trafficData.setClassTwoVolume(classTwoVolume);
					trafficData.setClassThreeVolume(classThreeVolume);
					trafficData.setOccupancyPercentage(occupancyPercentage);
					trafficData.setPeriod(20);
					trafficData.setVolume(volume);
					trafficData.setCongestionLevel(congestionLevel);
					trafficDataList.add(trafficData);
				});
			}
			trafficDataRepo.saveAll(trafficDataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteOldData() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -10);
		trafficDataRepo.deleteByDateLessThan(calendar.getTime());
	}

	private double calculateOccupancyPercentage(int volume) {
		double occupancyPercentage = (double) ((volume * 100) / MAX_VOLUME);
		return occupancyPercentage;
	}

	private CongestionLevel calculateCongestionLevel(double occupancyPercentage) {
		CongestionLevel congestionLevel = null;
		if (occupancyPercentage > 75) {
			congestionLevel = CongestionLevel.VERY_HIGH;

		} else if (occupancyPercentage > 50) {
			congestionLevel = CongestionLevel.HIGH;

		} else {
			congestionLevel = CongestionLevel.NORMAL;

		}

		return congestionLevel;
	}

}

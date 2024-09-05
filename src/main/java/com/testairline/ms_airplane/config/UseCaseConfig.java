/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.config;

import com.testairline.ms_airplane.adapters.AirplaneRepository;
import com.testairline.ms_airplane.adapters.FlightPlanRepository;
import com.testairline.ms_airplane.adapters.SeatClassRepository;
import com.testairline.ms_airplane.usecases.AirplaneUseCase;
import com.testairline.ms_airplane.usecases.PlanAFlightUseCase;
import com.testairline.ms_airplane.usecases.SeatClassUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

	@Bean
	public AirplaneUseCase createAirplaneUseCase(AirplaneRepository airplaneRepository) {
		return new AirplaneUseCase(airplaneRepository);
	}

	@Bean
	public SeatClassUseCase createSeatClassUseCase(SeatClassRepository seatClassRepository) {
		return new SeatClassUseCase(seatClassRepository);
	}

	@Bean
	public PlanAFlightUseCase createFlightPlannerUseCase(FlightPlanRepository flightPlanRepository) {
		return new PlanAFlightUseCase(flightPlanRepository);
	}
}

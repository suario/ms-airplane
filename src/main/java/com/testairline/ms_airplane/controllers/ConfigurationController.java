/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.controllers;

import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.AirplaneMapper;
import com.testairline.ms_airplane.mappers.FlightPlanMapper;
import com.testairline.ms_airplane.mappers.SeatClassMapper;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.models.FlightPlan;
import com.testairline.ms_airplane.models.SeatClass;
import com.testairline.ms_airplane.responses.AirplaneResponse;
import com.testairline.ms_airplane.responses.ConfigurationWrapperResponse;
import com.testairline.ms_airplane.responses.FlightPlanResponse;
import com.testairline.ms_airplane.responses.SeatClassResponse;
import com.testairline.ms_airplane.usecases.AirplaneUseCase;
import com.testairline.ms_airplane.usecases.PlanAFlightUseCase;
import com.testairline.ms_airplane.usecases.SeatClassUseCase;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configuration")
public class ConfigurationController {
	@Autowired
	private SeatClassUseCase seatClassUseCase;

	@Autowired
	private AirplaneUseCase airplaneUseCase;

	@Autowired
	private PlanAFlightUseCase planAFlightUseCase;

	private final SeatClassMapper seatClassMapper = Mappers.getMapper(SeatClassMapper.class);

	private final AirplaneMapper airplaneMapper = Mappers.getMapper(AirplaneMapper.class);

	private final FlightPlanMapper flightPlanMapper = Mappers.getMapper(FlightPlanMapper.class);

	@GetMapping(name = "/", produces = "application/json")
	@ResponseBody
	public ConfigurationWrapperResponse readConfiguration() throws BusinessException {
		List<SeatClass> seatClassDTOS = seatClassUseCase.getAllSeatClasses();
		List<SeatClassResponse> seatClasses = seatClassDTOS.stream().map(seatClassMapper::convertDTOToResponse)
				.collect(Collectors.toList());

		List<Airplane> airplaneDTOS = airplaneUseCase.getAllAirplanes();
		List<AirplaneResponse> airplanes = airplaneDTOS.stream().map(airplaneMapper::convertDTOToResponse)
				.collect(Collectors.toList());

		List<FlightPlan> plannedFlightsDTOs = planAFlightUseCase.getPlannedFlights();
		List<FlightPlanResponse> flightPlanes = plannedFlightsDTOs.stream().map(flightPlanMapper::convertDTOToResponse)
				.collect(Collectors.toList());

		return new ConfigurationWrapperResponse(seatClasses, airplanes, flightPlanes);
	}
}

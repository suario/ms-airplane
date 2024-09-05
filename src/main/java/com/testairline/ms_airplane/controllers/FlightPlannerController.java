/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.controllers;

import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.FlightPlanMapper;
import com.testairline.ms_airplane.models.FlightPlan;
import com.testairline.ms_airplane.requests.FlightPlanRequest;
import com.testairline.ms_airplane.usecases.PlanAFlightUseCase;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plan-flights")
public class FlightPlannerController {

	@Autowired
	private PlanAFlightUseCase planAFlightUseCase;

	private final FlightPlanMapper mapper = Mappers.getMapper(FlightPlanMapper.class);

	@PostMapping(name = "/", produces = {"text/plain", "application/json"})
	@ResponseBody
	public String saveAirplane(@Valid @RequestBody FlightPlanRequest flightPlanRequest) throws BusinessException {
		FlightPlan flightPlan = mapper.convertRequestToDTO(flightPlanRequest);
		planAFlightUseCase.planAFlight(flightPlan);

		return "Flights planned successfully!";
	}
}

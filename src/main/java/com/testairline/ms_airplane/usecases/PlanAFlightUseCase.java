/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.usecases;

import com.testairline.ms_airplane.adapters.FlightPlanRepository;
import com.testairline.ms_airplane.entities.FlightPlanEntity;
import com.testairline.ms_airplane.enums.ApplicationResponseEnum;
import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.FlightPlanMapper;
import com.testairline.ms_airplane.models.FlightPlan;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Slf4j
public class PlanAFlightUseCase {

	private final FlightPlanRepository flightPlanRepository;

	private final FlightPlanMapper mapper = Mappers.getMapper(FlightPlanMapper.class);

	public PlanAFlightUseCase(FlightPlanRepository flightPlanRepository) {
		this.flightPlanRepository = flightPlanRepository;
	}

	public void planAFlight(FlightPlan flightPlan) throws BusinessException {

		if (!isAValidPlan(flightPlan)) {
			throw new BusinessException(ApplicationResponseEnum.BAD_FLIGHT_PLAN);
		}

		FlightPlanEntity flightPlanEntity = mapper.convertDTOToEntity(flightPlan);
		try {
			flightPlanRepository.save(flightPlanEntity);
			log.info("Flights were successfully planned!");
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.FLIGHTS_PLAN_NOT_SAVED_EXCEPTION, exception);
		}
	}

	public List<FlightPlan> getPlannedFlights() throws BusinessException {

		List<FlightPlanEntity> result = null;
		try {
			result = flightPlanRepository.findAll();
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.FLIGHTS_PLAN_LISTED_EXCEPTION, exception);
		}

		return result.stream().map(mapper::convertEntityToDTO).collect(Collectors.toList());
	}

	private boolean isAValidPlan(FlightPlan flightPlan) {
		return (flightPlan.getEndDate().isAfter(flightPlan.getStartDate())
				|| flightPlan.getEndDate().isEqual(flightPlan.getStartDate()))
				&& flightPlanRepository.countPlansForTheGivenDates(flightPlan.getAirplane().getId(),
						flightPlan.getStartDate(), flightPlan.getEndDate()) == 0L;
	}
}

/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.mappers;

import com.testairline.ms_airplane.entities.FlightPlanEntity;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.models.FlightPlan;
import com.testairline.ms_airplane.models.Location;
import com.testairline.ms_airplane.requests.FlightPlanRequest;
import com.testairline.ms_airplane.responses.FlightPlanResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {Airplane.class, Location.class})
public interface FlightPlanMapper {

	@Mapping(target = "airplane", expression = "java(Airplane.builder().id(request.getAirplaneId()).build())")
	@Mapping(target = "location1", expression = "java(Location.builder().id(request.getLocation1Id()).build())")
	@Mapping(target = "location2", expression = "java(Location.builder().id(request.getLocation2Id()).build())")
	@Mapping(target = "id", ignore = true)
	FlightPlan convertRequestToDTO(FlightPlanRequest request);

	FlightPlanResponse convertDTOToResponse(FlightPlan dto);

	@Mapping(target = "airplane.seatRanges", ignore = true)
	FlightPlanEntity convertDTOToEntity(FlightPlan dto);

	@Mapping(target = "airplane.seatRanges", ignore = true)
	FlightPlan convertEntityToDTO(FlightPlanEntity entity);
}

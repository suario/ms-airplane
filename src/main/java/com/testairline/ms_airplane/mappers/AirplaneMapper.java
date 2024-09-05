/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.mappers;

import com.testairline.ms_airplane.entities.AirplaneEntity;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.requests.AirplaneRequest;
import com.testairline.ms_airplane.responses.AirplaneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = SeatRangeMapper.class)
public interface AirplaneMapper {

	@Mapping(target = "name", source = "name")
	Airplane convertRequestToDTO(AirplaneRequest request);

	@Mapping(target = "name", source = "name")
	AirplaneResponse convertDTOToResponse(Airplane dto);

	@Mapping(target = "name", source = "name")
	AirplaneEntity convertDTOToEntity(Airplane dto);

	@Mapping(target = "name", source = "name")
	Airplane convertEntityToDTO(AirplaneEntity entity);
}

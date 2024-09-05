/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.mappers;

import com.testairline.ms_airplane.entities.SeatClassEntity;
import com.testairline.ms_airplane.models.SeatClass;
import com.testairline.ms_airplane.requests.SeatClassRequest;
import com.testairline.ms_airplane.responses.SeatClassResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SeatClassMapper {

	@Mapping(target = "name", source = "name")
	SeatClass convertRequestToDTO(SeatClassRequest request);

	@Mapping(target = "name", source = "name")
	SeatClassResponse convertDTOToResponse(SeatClass dto);

	@Mapping(target = "name", source = "name")
	SeatClassEntity convertDTOToEntity(SeatClass dto);

	@Mapping(target = "name", source = "name")
	SeatClass convertEntityToDTO(SeatClassEntity entity);
}

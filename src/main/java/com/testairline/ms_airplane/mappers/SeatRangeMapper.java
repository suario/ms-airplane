/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.mappers;

import com.testairline.ms_airplane.entities.SeatClassEntity;
import com.testairline.ms_airplane.entities.SeatRangeEntity;
import com.testairline.ms_airplane.models.SeatRange;
import com.testairline.ms_airplane.requests.SeatRangeRequest;
import com.testairline.ms_airplane.responses.SeatRangeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = SeatClassEntity.class)
public interface SeatRangeMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "seatClass", ignore = true)
	SeatRange convertRequestToDTO(SeatRangeRequest request);

	@Mapping(target = "airplane", ignore = true)
	@Mapping(target = "seatClass", expression = "java(SeatClassEntity.builder().id(dto.getSeatClassId()).build())")
	SeatRangeEntity convertDTOToEntity(SeatRange dto);

	@Mapping(target = "seatClassId", expression = "java(entity.getSeatClass().getId())")
	@Mapping(target = "seatClass", expression = "java(entity.getSeatClass().getName())")
	SeatRange convertEntityToDTO(SeatRangeEntity entity);

	@Mapping(target = "seatClass", source = "seatClassId")
	SeatRangeResponse convertDTOToResponse(SeatRange dto);
}

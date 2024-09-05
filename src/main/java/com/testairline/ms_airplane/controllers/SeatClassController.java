/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.controllers;

import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.SeatClassMapper;
import com.testairline.ms_airplane.models.SeatClass;
import com.testairline.ms_airplane.requests.SeatClassRequest;
import com.testairline.ms_airplane.responses.SeatClassResponse;
import com.testairline.ms_airplane.responses.SeatClassWrapperResponse;
import com.testairline.ms_airplane.usecases.SeatClassUseCase;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seat-class")
public class SeatClassController {

	@Autowired
	private SeatClassUseCase seatClassUseCase;

	private final SeatClassMapper mapper = Mappers.getMapper(SeatClassMapper.class);

	@PostMapping(name = "/", produces = "application/json")
	@ResponseBody
	public SeatClassResponse saveSeatClass(@Valid @RequestBody SeatClassRequest seatClassRequest)
			throws BusinessException {
		SeatClass seatClass = mapper.convertRequestToDTO(seatClassRequest);
		SeatClass result = seatClassUseCase.saveSeatClass(seatClass);

		return mapper.convertDTOToResponse(result);
	}

	@GetMapping(name = "/", produces = "application/json")
	@ResponseBody
	public SeatClassWrapperResponse getAllSeatClasses() throws BusinessException {
		List<SeatClass> result = seatClassUseCase.getAllSeatClasses();
		List<SeatClassResponse> seatClasses = result.stream().map(mapper::convertDTOToResponse)
				.collect(Collectors.toList());

		return new SeatClassWrapperResponse(seatClasses);
	}
}

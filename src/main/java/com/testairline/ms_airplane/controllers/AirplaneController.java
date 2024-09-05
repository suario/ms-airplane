/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.controllers;

import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.AirplaneMapper;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.requests.AirplaneRequest;
import com.testairline.ms_airplane.responses.AirplaneResponse;
import com.testairline.ms_airplane.usecases.AirplaneUseCase;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

	@Autowired
	private AirplaneUseCase airplaneUseCase;

	private final AirplaneMapper mapper = Mappers.getMapper(AirplaneMapper.class);

	@PostMapping(name = "/", produces = "application/json")
	@ResponseBody
	public AirplaneResponse saveAirplane(@Valid @RequestBody AirplaneRequest airplaneRequest) throws BusinessException {
		Airplane airplane = mapper.convertRequestToDTO(airplaneRequest);
		Airplane result = airplaneUseCase.saveAirplane(airplane);

		return mapper.convertDTOToResponse(result);
	}
}

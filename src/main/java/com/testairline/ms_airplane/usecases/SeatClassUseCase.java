/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.usecases;

import com.testairline.ms_airplane.adapters.SeatClassRepository;
import com.testairline.ms_airplane.entities.SeatClassEntity;
import com.testairline.ms_airplane.enums.ApplicationResponseEnum;
import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.SeatClassMapper;
import com.testairline.ms_airplane.models.SeatClass;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Slf4j
public class SeatClassUseCase {

	private final SeatClassRepository seatClassRepository;

	private final SeatClassMapper mapper = Mappers.getMapper(SeatClassMapper.class);

	public SeatClassUseCase(SeatClassRepository seatClassRepository) {
		this.seatClassRepository = seatClassRepository;
	}

	public SeatClass saveSeatClass(SeatClass seatClass) throws BusinessException {

		SeatClassEntity seatClassEntity = mapper.convertDTOToEntity(seatClass);
		SeatClassEntity result = null;
		try {
			result = seatClassRepository.save(seatClassEntity);
			log.info("Seat class saved!");
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.SEAT_CLASS_NOT_SAVED_EXCEPTION, exception);
		}

		return mapper.convertEntityToDTO(result);
	}

	public List<SeatClass> getAllSeatClasses() throws BusinessException {

		List<SeatClassEntity> result = null;
		try {
			result = seatClassRepository.findAll();
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.SEAT_CLASS_LISTED_EXCEPTION, exception);
		}

		return result.stream().map(mapper::convertEntityToDTO).collect(Collectors.toList());
	}
}

/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.usecases;

import com.testairline.ms_airplane.adapters.AirplaneRepository;
import com.testairline.ms_airplane.entities.AirplaneEntity;
import com.testairline.ms_airplane.enums.ApplicationResponseEnum;
import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.mappers.AirplaneMapper;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.models.SeatRange;
import com.testairline.ms_airplane.utils.AirplaneUtils;
import com.testairline.ms_airplane.utils.Constants;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Slf4j
public class AirplaneUseCase {

	private final AirplaneRepository airplaneRepository;

	private final AirplaneMapper mapper = Mappers.getMapper(AirplaneMapper.class);

	public AirplaneUseCase(AirplaneRepository airplaneRepository) {
		this.airplaneRepository = airplaneRepository;
	}

	public Airplane saveAirplane(Airplane airplane) throws BusinessException {

		if (!areSeatRangesValid(airplane)) {
			throw new BusinessException(ApplicationResponseEnum.SEAT_RANGE_NOT_VALID);
		}

		AirplaneEntity airplaneEntity = mapper.convertDTOToEntity(airplane);
		airplaneEntity.getSeatRanges().forEach(item -> item.setAirplane(airplaneEntity));

		AirplaneEntity result = null;
		try {
			result = airplaneRepository.save(airplaneEntity);
			log.info("Airplane saved!");
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.AIRPLANE_NOT_SAVED_EXCEPTION, exception);
		}

		return mapper.convertEntityToDTO(result);
	}

	private boolean areSeatRangesValid(Airplane airplane) {

		boolean[][] seats = AirplaneUtils.createSeats();

		for (SeatRange seat : airplane.getSeatRanges()) {
			if (!Constants.SEAT_COLUMNS.containsKey(seat.getColumnFrom())
					|| !Constants.SEAT_COLUMNS.containsKey(seat.getColumnTo())) {
				return false;
			}
			int startColumn = Constants.SEAT_COLUMNS.get(seat.getColumnFrom());
			int endColumn = Constants.SEAT_COLUMNS.get(seat.getColumnTo());
			int startRow = seat.getRowFrom();
			int endRow = seat.getRowTo();

			if (startColumn <= endColumn && startRow <= endRow) {
				for (int columnIndex = startColumn; columnIndex < endColumn; columnIndex++) {
					for (int rowIndex = startRow; rowIndex < endRow; rowIndex++) {
						if (seats[columnIndex][rowIndex]) {
							return false;
						}
						seats[columnIndex][rowIndex] = true;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public List<Airplane> getAllAirplanes() throws BusinessException {

		List<AirplaneEntity> result = null;
		try {
			result = airplaneRepository.findAll();
		} catch (Exception exception) {
			throw new BusinessException(ApplicationResponseEnum.AIRPLANE_LISTED_EXCEPTION, exception);
		}

		return result.stream().map(mapper::convertEntityToDTO).collect(Collectors.toList());
	}
}

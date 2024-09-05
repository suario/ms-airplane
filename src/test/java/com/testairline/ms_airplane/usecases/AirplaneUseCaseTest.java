/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.testairline.ms_airplane.adapters.AirplaneRepository;
import com.testairline.ms_airplane.entities.AirplaneEntity;
import com.testairline.ms_airplane.enums.ApplicationResponseEnum;
import com.testairline.ms_airplane.exceptions.BusinessException;
import com.testairline.ms_airplane.models.Airplane;
import com.testairline.ms_airplane.models.SeatRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class AirplaneUseCaseTest {

	@Mock
	private AirplaneRepository airplaneRepositoryMock;

	Airplane airplane;

	private AirplaneUseCase airplaneUseCase;

	@BeforeEach
	void setUp() {
		this.airplaneUseCase = new AirplaneUseCase(airplaneRepositoryMock);

		airplane = new Airplane();
		airplane.setName("Name");
		List<SeatRange> ranges = new ArrayList<>();
		SeatRange seat1 = new SeatRange();
		seat1.setSeatClass("First Class");
		seat1.setSeatClassId(1L);
		seat1.setColumnFrom("A");
		seat1.setColumnTo("C");
		seat1.setRowFrom(2);
		seat1.setRowTo(15);
		ranges.add(seat1);

		SeatRange seat2 = new SeatRange();
		seat2.setSeatClass("Economy");
		seat2.setSeatClassId(2L);
		seat2.setColumnFrom("E");
		seat2.setColumnTo("G");
		seat2.setRowFrom(2);
		seat2.setRowTo(15);
		ranges.add(seat2);
		airplane.setSeatRanges(ranges);
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void saveAirplane() throws BusinessException {
		AirplaneEntity entity = new AirplaneEntity();
		entity.setName("Testo");
		when(airplaneRepositoryMock.save(any(AirplaneEntity.class))).thenReturn(entity);
		Airplane result = this.airplaneUseCase.saveAirplane(airplane);

		assertNotNull(result);
		assertEquals("Testo", result.getName());
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void saveAirplane2() {
		List<SeatRange> ranges = new ArrayList<>();
		SeatRange seat1 = new SeatRange();
		seat1.setSeatClass("First Class");
		seat1.setSeatClassId(1L);
		seat1.setColumnFrom("D");
		seat1.setColumnTo("C");
		seat1.setRowFrom(2);
		seat1.setRowTo(15);
		ranges.add(seat1);

		airplane.setSeatRanges(ranges);
		BusinessException businessException = assertThrows(BusinessException.class,
				() -> this.airplaneUseCase.saveAirplane(airplane));

		assertEquals(ApplicationResponseEnum.SEAT_RANGE_NOT_VALID, businessException.getResponseCode());
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void saveAirplane3() {
		when(airplaneRepositoryMock.save(any(AirplaneEntity.class))).thenThrow(new IllegalArgumentException());
		BusinessException businessException = assertThrows(BusinessException.class,
				() -> this.airplaneUseCase.saveAirplane(airplane));

		assertEquals(ApplicationResponseEnum.AIRPLANE_NOT_SAVED_EXCEPTION, businessException.getResponseCode());
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void areSeatRangesValid() {
		Boolean result = ReflectionTestUtils.invokeMethod(this.airplaneUseCase, "areSeatRangesValid", airplane);
		assertTrue(Objects.requireNonNull(result));
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void areSeatRangesValid2() {
		SeatRange seat2 = new SeatRange();
		seat2.setSeatClass("Economy");
		seat2.setSeatClassId(2L);
		seat2.setColumnFrom("F");
		seat2.setColumnTo("G");
		seat2.setRowFrom(5);
		seat2.setRowTo(15);

		airplane.getSeatRanges().add(seat2);
		Boolean result = ReflectionTestUtils.invokeMethod(this.airplaneUseCase, "areSeatRangesValid", airplane);

		assertFalse(Objects.requireNonNull(result));
	}

	@Test
	@DisplayName("verifies if the airplane was properly saved")
	void areSeatRangesValid3() {
		SeatRange seat2 = new SeatRange();
		seat2.setSeatClass("Economy Pro");
		seat2.setSeatClassId(3L);
		seat2.setColumnFrom("F");
		seat2.setColumnTo("A");
		seat2.setRowFrom(20);
		seat2.setRowTo(31);

		airplane.getSeatRanges().add(seat2);
		Boolean result = ReflectionTestUtils.invokeMethod(this.airplaneUseCase, "areSeatRangesValid", airplane);

		assertFalse(Objects.requireNonNull(result));
	}
}

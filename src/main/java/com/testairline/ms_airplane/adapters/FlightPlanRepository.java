/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.adapters;

import com.testairline.ms_airplane.entities.FlightPlanEntity;
import java.time.LocalDate;
import java.util.List;

public interface FlightPlanRepository {

	FlightPlanEntity save(FlightPlanEntity entity);

	List<FlightPlanEntity> findAll();

	Long countPlansForTheGivenDates(Long airplaneId, LocalDate start, LocalDate end);
}

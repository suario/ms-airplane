/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.repositories;

import com.testairline.ms_airplane.adapters.FlightPlanRepository;
import com.testairline.ms_airplane.entities.FlightPlanEntity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPlanDataRepository extends JpaRepository<FlightPlanEntity, Long>, FlightPlanRepository {

	@Query(value = "SELECT count(*) FROM flights_planner fp WHERE fp.airplane_id = :airplaneId "
			+ "AND ((fp.start_date BETWEEN :startDate AND :endDate) || (fp.end_date BETWEEN :startDate AND :endDate))", nativeQuery = true)
	Long countPlansForTheGivenDates(Long airplaneId, LocalDate startDate, LocalDate endDate);
}

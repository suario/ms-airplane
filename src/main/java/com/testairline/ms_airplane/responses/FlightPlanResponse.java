/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FlightPlanResponse {
	private Long id;
	private AirplaneResponse airplane;
	private LocationResponse location1;
	private LocationResponse location2;
	private LocalDate startDate;
	private LocalDate endDate;
}

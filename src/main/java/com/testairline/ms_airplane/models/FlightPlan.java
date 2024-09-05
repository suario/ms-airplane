/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.models;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FlightPlan {

	private Long id;
	private Airplane airplane;
	private Location location1;
	private Location location2;
	private LocalDate startDate;
	private LocalDate endDate;
}

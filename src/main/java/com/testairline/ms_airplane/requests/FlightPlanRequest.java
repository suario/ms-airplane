/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class FlightPlanRequest {

	@NotNull(message = "Airplane Id cannot be null") @Min(value = 1, message = "Value must be greater than 0")
	private Long airplaneId;

	@NotNull(message = "Location 1 Id cannot be null") @Min(value = 1, message = "Value must be greater than 0")
	private Long location1Id;

	@NotNull(message = "Location 2 Id cannot be null") @Min(value = 1, message = "Value must be greater than 0")
	private Long location2Id;

	@NotNull(message = "Start date cannot be null") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;

	@NotNull(message = "End date cannot be null") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;
}

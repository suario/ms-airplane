/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
public class AirplaneRequest {
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 1, max = 45, message = "The size of the name must be between 1 and 45")
	private String name;

	@NotEmpty(message = "The list of seat ranges cannot be empty")
	private List<@Valid SeatRangeRequest> seatRanges;
}

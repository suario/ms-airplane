/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SeatClassRequest {

	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 1, max = 45, message = "The size of the name must be between 1 and 45")
	private String name;

	@Min(value = 10, message = "The minimum accepted base price is 10")
	@NotNull(message = "Base price cannot be empty") private Double basePrice;
}

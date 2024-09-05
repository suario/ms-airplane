/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SeatRangeRequest {

	@NotNull(message = "Seat class cannot be null") @JsonProperty("seatClass")
	private Long seatClassId;

	@Size(min = 1, max = 1, message = "Columns can only have one character")
	private String columnFrom;

	@Size(min = 1, max = 1, message = "Columns can only have one character")
	private String columnTo;

	@NotNull(message = "Rows cannot be null") private Integer rowFrom;

	@NotNull(message = "Rows cannot be null") private Integer rowTo;
}

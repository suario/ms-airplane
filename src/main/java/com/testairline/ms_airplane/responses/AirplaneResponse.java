/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import java.util.List;
import lombok.Data;

@Data
public class AirplaneResponse {

	private Long id;
	private String name;

	private List<SeatRangeResponse> seatRanges;
}

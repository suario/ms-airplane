/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import lombok.Data;

@Data
public class SeatRangeResponse {
	private Long id;

	private Long seatClass;

	private String columnFrom;

	private String columnTo;

	private Integer rowFrom;

	private Integer rowTo;
}

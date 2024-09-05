/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.models;

import lombok.Data;

@Data
public class SeatRange {

	private Long id;

	private Long seatClassId;

	private String seatClass;

	private String columnFrom;

	private String columnTo;

	private Integer rowFrom;

	private Integer rowTo;
}

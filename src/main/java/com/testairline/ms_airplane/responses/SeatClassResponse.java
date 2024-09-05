/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import lombok.Data;

@Data
public class SeatClassResponse {
	private Long id;
	private String name;
	private Double basePrice;
}

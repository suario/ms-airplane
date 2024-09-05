/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.models;

import lombok.Data;

@Data
public class SeatClass {

	private Long id;
	private String name;
	private Double basePrice;
}

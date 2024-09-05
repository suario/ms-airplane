/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airplane {

	private Long id;
	private String name;

	private List<SeatRange> seatRanges;
}

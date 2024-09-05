/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
	private Long id;

	private String name;
}

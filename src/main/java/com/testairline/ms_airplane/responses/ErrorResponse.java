/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private final Integer code;
	private final String description;
	private Map<String, String> errors;
}

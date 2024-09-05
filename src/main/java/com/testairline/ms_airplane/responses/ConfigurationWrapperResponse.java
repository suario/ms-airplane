/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.responses;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ConfigurationWrapperResponse {

	private final List<SeatClassResponse> seatClasses;

	private final List<AirplaneResponse> airplanes;

	private final List<FlightPlanResponse> plans;
}

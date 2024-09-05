/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.enums;

import lombok.Getter;

@Getter
public enum ApplicationResponseEnum {
	AIRPLANE_BAD_REQUEST(300, "Bad request"), AIRPLANE_VALIDATION_ERROR(301,
			"There are some Validation errors"), AIRPLANE_NOT_SAVED_EXCEPTION(302,
					"Airplane couldn't be saved!"), AIRPLANE_LISTED_EXCEPTION(303,
							"Error while getting the airplanes!"), SEAT_CLASS_NOT_SAVED_EXCEPTION(304,
									"Seat class couldn't be saved!"), SEAT_CLASS_LISTED_EXCEPTION(305,
											"Error while getting seat classes!"), SEAT_RANGE_NOT_VALID(306,
													"The seat distribution are not well arranged!"), FLIGHTS_PLAN_NOT_SAVED_EXCEPTION(
															307,
															"Flights' plan couldn't be saved!"), FLIGHTS_PLAN_LISTED_EXCEPTION(
																	308,
																	"Error while getting flights' plans!"), BAD_FLIGHT_PLAN(
																			306,
																			"The given dates are not properly set or the airplane is already booked for that range of dates!");

	private final int code;
	private final String message;

	ApplicationResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
}

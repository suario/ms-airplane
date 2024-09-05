/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AirplaneUtils {

	public static boolean[][] createSeats() {
		return new boolean[Constants.SEAT_COLUMNS.size()][Constants.MAX_ROW_COUNT];
	}
}

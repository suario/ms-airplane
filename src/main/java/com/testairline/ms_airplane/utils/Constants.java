/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.utils;

import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
	public static final Map<String, Integer> SEAT_COLUMNS = Map.of("A", 0, "B", 1, "C", 2, "D", 3, "E", 4, "F", 5, "G",
			6, "H", 7, "I", 8, "J", 9);

	public static final int MAX_ROW_COUNT = 150;
}

/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.adapters;

import com.testairline.ms_airplane.entities.AirplaneEntity;
import java.util.List;

public interface AirplaneRepository {
	AirplaneEntity save(AirplaneEntity entity);

	List<AirplaneEntity> findAll();
}

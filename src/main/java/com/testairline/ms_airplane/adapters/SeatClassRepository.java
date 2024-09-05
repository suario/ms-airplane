/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.adapters;

import com.testairline.ms_airplane.entities.SeatClassEntity;
import java.util.List;

public interface SeatClassRepository {
	SeatClassEntity save(SeatClassEntity entity);

	List<SeatClassEntity> findAll();
}

/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.repositories;

import com.testairline.ms_airplane.adapters.AirplaneRepository;
import com.testairline.ms_airplane.entities.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneDataRepository extends JpaRepository<AirplaneEntity, Long>, AirplaneRepository {
}

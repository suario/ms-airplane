/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.repositories;

import com.testairline.ms_airplane.adapters.SeatClassRepository;
import com.testairline.ms_airplane.entities.SeatClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatClassDataRepository extends JpaRepository<SeatClassEntity, Long>, SeatClassRepository {
}

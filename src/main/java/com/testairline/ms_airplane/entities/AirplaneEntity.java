/* (C) Jorge Suarez 2024 */
package com.testairline.ms_airplane.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "airplane")
public class AirplaneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SeatRangeEntity> seatRanges;
}

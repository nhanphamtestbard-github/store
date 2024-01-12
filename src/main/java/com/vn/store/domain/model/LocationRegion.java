package com.vn.store.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location_region")
public class LocationRegion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "province_id", nullable = false)
	private String provinceId;
	
	@Column(name = "province_name", nullable = false)
	private String provinceName;
	
	@Column(name ="district_id", nullable = false)
	private String districtId;
	
	@Column(name = "district_name", nullable = false)
	private String districtName;
	
	@Column(name = "ward_id", nullable = false)
	private String wardId;
	
	@Column(name = "ward_name", nullable = false)
	private String wardName;
	
	@Column(name = "address")
	private String address;
}

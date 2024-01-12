package com.vn.store.domain.model;

import java.sql.Timestamp;

import com.vn.store.domain.BaseEntity;
import com.vn.store.domain.enums.EnumGender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "staffs")
public class Staff extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "birth_date", nullable = false)
	private Timestamp birthDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", length = 20)
	private EnumGender gender;

	@Column(name = "phone", unique = true, nullable = false)
	private String phone;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@OneToOne
	@JoinColumn(name = "location_region_id", nullable = false)
	private LocationRegion locationRegion;

	@OneToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "positon_id", referencedColumnName = "id", nullable = false)
	private Position position;

}

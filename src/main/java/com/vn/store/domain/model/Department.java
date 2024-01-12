package com.vn.store.domain.model;

import java.util.List;

import com.vn.store.domain.BaseEntity;
import com.vn.store.domain.enums.EnumDepartment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EnumDepartment name;
	
	@OneToMany(targetEntity = Staff.class)
	private List<Staff> staffs;
}

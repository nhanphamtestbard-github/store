package com.vn.store.domain.dto;

import com.vn.store.domain.model.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

	private Long id;
	
	private String code;

	public Department toDepartment() {
		return new Department().setId(id).setCode(code);
	}
}

package com.vn.store.domain.dto;

import com.vn.store.domain.enums.EnumRole;
import com.vn.store.domain.model.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO {
	
	private Long id;
	private String code;

	public Role toRole() {
		return new Role().setId(id).setCode(code).setName(EnumRole.valueOf(code));
	}
}

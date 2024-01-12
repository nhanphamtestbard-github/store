package com.vn.store.domain.dto;

import com.vn.store.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Long id;

	private String userName;

	private String password;

	private RoleDTO role;

	public User toUser() {
		return new User().setId(id).setUsername(userName).setPassword(password).setRole(role.toRole());
	}
}

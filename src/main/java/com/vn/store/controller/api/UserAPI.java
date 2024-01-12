package com.vn.store.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.store.domain.dto.RoleDTO;
import com.vn.store.domain.dto.UserDTO;
import com.vn.store.domain.model.User;
import com.vn.store.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
	
	@Autowired
	private UserService UserService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return UserService.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody UserDTO userDTO) {
		
		String userName = userDTO.getUserName();
		String password= userDTO.getPassword();
		RoleDTO roleDTO = userDTO.getRole();
		
		return UserService.save(userDTO.toUser());
	}
}

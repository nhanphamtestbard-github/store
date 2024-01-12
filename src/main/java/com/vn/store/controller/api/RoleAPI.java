package com.vn.store.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.store.domain.dto.RoleDTO;
import com.vn.store.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleAPI {
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<?>getAllRole(){
		List<RoleDTO> roles= roleService.getAllRoleDTOs();
		if (roles.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK); 
	}
}

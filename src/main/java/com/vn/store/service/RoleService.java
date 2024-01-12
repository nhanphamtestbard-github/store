package com.vn.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.store.domain.dto.RoleDTO;
import com.vn.store.domain.model.Role;
import com.vn.store.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	public Optional<Role>findById(Long id){
		return roleRepository.findById(id);
	}
	
    public Role findByCode(String code) {
        return roleRepository.findByCode(code);
    }
    
    public List<RoleDTO> getAllRoleDTOs(){
    	return roleRepository.getAllRoleDTOs();
    }
}

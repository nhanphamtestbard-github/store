package com.vn.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.store.domain.dto.RoleDTO;
import com.vn.store.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByCode(String code);
	
	@Query("SELECT NEW com.vn.store.domain.dto.RoleDTO("+
			 	"id, " +
	            "code" +
	            ") " +
	        "FROM Role")
	List<RoleDTO> getAllRoleDTOs();
}

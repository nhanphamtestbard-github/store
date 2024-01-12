package com.vn.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.store.domain.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}

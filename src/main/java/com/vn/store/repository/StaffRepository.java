package com.vn.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.store.domain.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}

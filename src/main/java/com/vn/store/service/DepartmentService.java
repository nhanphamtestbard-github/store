package com.vn.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vn.store.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
}

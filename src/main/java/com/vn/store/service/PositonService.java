package com.vn.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.store.domain.model.Position;
import com.vn.store.repository.PositonRepository;

@Service
public class PositonService {

	@Autowired
	private PositonRepository positonRepository;
	
	public List<Position> findAll(){
		return positonRepository.findAll();
	}
}

package com.vn.store.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.store.domain.model.LocationRegion;
import com.vn.store.repository.LocationRegionRepository;

@Service
public class LocationRegionService {
	@Autowired
	private LocationRegionRepository locationRegionRepository;

	public Optional<LocationRegion> findById(Long id) {
		return Optional.empty();
	}

	public LocationRegion save(LocationRegion locationRegion) {
		return locationRegionRepository.save(locationRegion);
	}
}

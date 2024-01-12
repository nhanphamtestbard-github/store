package com.vn.store.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vn.store.domain.model.Image;
import com.vn.store.repository.ImageRepository;

@Service
@Transactional
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public Optional<Image> findById(String id){
		return Optional.empty();
	}
	
	public Image save(Image image) {
		return imageRepository.save(image);
	}
	
	public void delete(String id) {
		imageRepository.deleteById(id);
	}
}

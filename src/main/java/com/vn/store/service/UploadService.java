package com.vn.store.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

/**
 * UploadService
 */
@Service
public class UploadService {
	@Autowired
	private Cloudinary cloudinary;

	public Map uploadImage(MultipartFile multipartFile, Map options) throws IOException {
		return cloudinary.uploader().upload(multipartFile.getBytes(), options);
	}

	public Map destroyImage(String publicId, Map options) throws IOException {
		return cloudinary.uploader().destroy(publicId, options);
	}

}

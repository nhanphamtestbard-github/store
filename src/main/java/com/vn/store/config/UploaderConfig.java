package com.vn.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@EnableConfigurationProperties(CloudinaryConfig.class)
public class UploaderConfig {

	@Autowired
	private CloudinaryConfig cloudinaryConfig;

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", cloudinaryConfig.getCloudName(), "api_key", cloudinaryConfig.getApiKey(),
				"api_secret", cloudinaryConfig.getApiSecret()));
	}
}

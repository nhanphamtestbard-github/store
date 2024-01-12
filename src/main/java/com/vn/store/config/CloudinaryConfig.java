package com.vn.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "application.uploader")
@Getter
@Setter
@Data
public class CloudinaryConfig {

	@Value("${application.uploader.cloud-name}")
	private String cloudName;
	
	@Value("${application.uploader.api-key}")
	private String apiKey;
	
	@Value("${application.uploader.api-secret}")
	private String apiSecret;

}

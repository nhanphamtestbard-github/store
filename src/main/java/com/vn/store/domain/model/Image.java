package com.vn.store.domain.model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images")
public class Image {

	/**
	 * Image id
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	/**
	 * File name
	 */
	@Column(name = "file_name")
	private String fileName;

	/**
	 * File folder
	 */
	@Column(name = "file_folder")
	private String fileFolder;

	/**
	 * File url
	 */
	@Column(name = "file_url")
	private String fileUrl;

	/**
	 * File type
	 */
	@Column(name = "file_type")
	private String fileType;

	/**
	 * cloud id
	 */
	@Column(name = "cloud_id")
	private String cloudId;

	/**
	 * time stamp
	 */
	@Column(name = "ts", columnDefinition = "BIGINT DEFAULT 0")
	private Long ts = new Date().getTime();
}

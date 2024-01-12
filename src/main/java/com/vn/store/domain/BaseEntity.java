package com.vn.store.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * BaseEntity
 * 
 * @author lt_tung
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

	/**
	 * deleted
	 */
	@Column(columnDefinition = "boolean default false")
	private Boolean deleted = false;

	/**
	 * created at
	 */
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	/**
	 * created by
	 */
	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	/**
	 * updated at
	 */
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	/**
	 * updated by
	 */
	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;
}

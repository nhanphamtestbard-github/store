package com.vn.store.domain.dto;

import com.vn.store.domain.model.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PositionDTO {
	private Long id;

	private String code;

	public Position toPosition() {
		return new Position().setId(id).setCode(code);
	}
}

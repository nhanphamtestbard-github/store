package com.vn.store.domain.dto;

import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

import com.vn.store.common.utils.AppUtils;
import com.vn.store.domain.enums.EnumDepartment;
import com.vn.store.domain.enums.EnumGender;
import com.vn.store.domain.enums.EnumPositon;
import com.vn.store.domain.model.Department;
import com.vn.store.domain.model.Image;
import com.vn.store.domain.model.LocationRegion;
import com.vn.store.domain.model.Position;
import com.vn.store.domain.model.Role;
import com.vn.store.domain.model.Staff;
import com.vn.store.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaffDTO {

	private Long id;
	private String fullName;
	private String birthDate;
	private String gender;
	private String phone;

	private String username;
	private String password;
	private String roleId;

	private String provinceId;
	private String provinceName;
	private String districtId;
	private String districtName;
	private String wardId;
	private String wardName;
	private String address;
	
	private String departmentId;
	
	private String positionId;
	
	private MultipartFile file;

	public User toUser(Role role) {
		return new User()
				.setId(id)
				.setUsername(username)
				.setPassword(password)
				.setRole(role);
	}

	public LocationRegion toLocationRegion() {
		return new LocationRegion()
				.setId(id)
				.setProvinceId(provinceId)
				.setProvinceName(provinceName)
				.setDistrictId(districtId)
				.setDistrictName(districtName)
				.setWardId(wardId)
				.setWardName(wardName)
				.setAddress(address);
	}
	
	public Department toDepartment() {
		return new Department()
				.setId(id)
				.setName(EnumDepartment.valueOf(departmentId));
	}
	
	public Position toPosition() {
		return new Position()
				.setId(id)
				.setName(EnumPositon.valueOf(positionId));
	}
	
	public Staff toStaff(User user, LocationRegion locationRegion, Image image, Department department, Position position) throws ParseException {
		return new Staff()
				.setId(id)
				.setFullName(fullName)
				.setBirthDate(AppUtils.convertStringToTimestamp(birthDate))
				.setGender(EnumGender.valueOf(gender))
				.setPhone(phone)
				.setUser(user)
				.setLocationRegion(locationRegion)
				.setImage(image)
				.setDepartment(department)
				.setPosition(position);
		
	}
}

package com.vn.store.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vn.store.common.exception.DataInputException;
import com.vn.store.common.utils.AppUtils;
import com.vn.store.common.utils.Containt;
import com.vn.store.common.utils.UploadUtil;
import com.vn.store.domain.dto.StaffDTO;
import com.vn.store.domain.enums.EnumGender;
import com.vn.store.domain.model.Department;
import com.vn.store.domain.model.Image;
import com.vn.store.domain.model.LocationRegion;
import com.vn.store.domain.model.Position;
import com.vn.store.domain.model.Staff;
import com.vn.store.domain.model.User;
import com.vn.store.repository.StaffRepository;

/**
 * Staff Service
 * @category Service
 * @author lt_tung
 */
@Service
@Transactional
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private LocationRegionService locationRegionService;

	@Autowired
	private UserService userService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private UploadService uploadService;

	@Autowired
	private UploadUtil uploadUtil;

	public List<Staff> findAll() {
		return staffRepository.findAll();
	}

	public Optional<Staff> findById(Long id) {
		return staffRepository.findById(id);
	}

	public Staff save(Staff staff) {

		locationRegionService.save(staff.getLocationRegion());

		userService.save(staff.getUser());

		return staffRepository.save(staff);
	}

	public Staff createStaffWithImage(StaffDTO staffDTO, User user, LocationRegion locationRegion,
			Department department, Position position) throws ParseException {

		Staff staff = new Staff();

		String fullName = staffDTO.getFullName();
		Timestamp birthDate = AppUtils.convertStringToTimestamp(staffDTO.getBirthDate());

		EnumGender gender = EnumGender.valueOf(staffDTO.getGender());
		String phone = staffDTO.getPhone();

		MultipartFile file = staffDTO.getFile();
		String fileType = file.getContentType();
		fileType = fileType.substring(0, 5);
		Image image = new Image();
		image.setFileType(fileType);
		image = imageService.save(image);

		if (fileType.equals(Containt.IMAGE)) {
			image = uploadAndSaveImage(staffDTO.getFile(), image);
		}

		user = userService.save(user);
		locationRegion = locationRegionService.save(locationRegion);

		staff.setId(null).setFullName(fullName).setBirthDate(birthDate).setGender(gender).setPhone(phone).setUser(user)
				.setLocationRegion(locationRegion).setImage(image).setDepartment(department).setPosition(position);

		return save(staff);
	}

	private Image uploadAndSaveImage(MultipartFile file, Image image) {
		try {
			Map uploadResult = uploadService.uploadImage(file,
					uploadUtil.buildImageUploadParams(image, Containt.STAFF_IMAGE_UPLOAD_FOLDER));
			String fileUrl = (String) uploadResult.get("secure_url");
			String fileFormat = (String) uploadResult.get("format");

			image.setFileName(image.getId() + "." + fileFormat);
			image.setFileUrl(fileUrl);
			image.setFileFolder(Containt.STAFF_IMAGE_UPLOAD_FOLDER);
			image.setCloudId(image.getFileFolder() + "/" + image.getId());

			return imageService.save(image);

		} catch (IOException e) {
			throw new DataInputException("Upload image failed.");
		}
	}

	public Staff saveWithAvatar(Staff staff, MultipartFile file) {

		Image oldImage = staff.getImage();
		try {
			uploadService.destroyImage(oldImage.getCloudId(),
					uploadUtil.buildImageDestroyParams(oldImage, oldImage.getCloudId()));
			imageService.delete(oldImage.getId());
			String fileType = file.getContentType();
			assert fileType != null;
			fileType = fileType.substring(0, 5);
			Image image = new Image();
			image.setFileType(fileType);
			image = imageService.save(image);

			if (fileType.equals(Containt.IMAGE)) {
				image = uploadAndSaveImage(file, image);
			}
			staff.setImage(image);
			staff = staffRepository.save(staff);
			return staff;
		} catch (IOException e) {
			throw new DataInputException("Delete image failed.");
		}
	}
}

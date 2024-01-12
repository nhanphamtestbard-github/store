package com.vn.store.common.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudinary.utils.ObjectUtils;
import com.vn.store.common.exception.DataInputException;
import com.vn.store.domain.model.Image;

@Component
public class UploadUtil {

	public Map buildImageUploadParams(Image image, String folder) {
		if (image == null || image.getId() == null)
			throw new DataInputException("Can't upload image.");

		String publicId = String.format("%s/%s", folder, image.getId());

		return ObjectUtils.asMap("public_id", publicId, "overwrite", true, "resource_type", "image");
	}

	public Map buildImageDestroyParams(Image image, String publicId) {
		if (image == null || image.getId() == null)
			throw new DataInputException("Can't destroy image.");

		return ObjectUtils.asMap("public_id", publicId, "overwrite", true, "resource_type", "image");
	}
}

package com.vn.store.common.exception;

import java.io.IOException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomExceptionControllerAdvice {
	@ExceptionHandler(MultipartException.class)
	void handleMultipartException(MultipartException ex, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), "Please select a file");
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public void handleConstraintViolationException(ConstraintViolationException ex, HttpServletResponse response)
			throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}

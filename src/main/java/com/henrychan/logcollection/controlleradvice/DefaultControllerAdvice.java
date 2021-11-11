package com.henrychan.logcollection.controlleradvice;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.henrychan.logcollection.exception.UnknownException;

/**
 * 
 * @author Henry
 * handles exceptions ... TODO handle {@link UnknownException}
 */
@ControllerAdvice
public class DefaultControllerAdvice {

	@ExceptionHandler(value = { FileNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(FileNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", request.getParameter("filename") + " not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}

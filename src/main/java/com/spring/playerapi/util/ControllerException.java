package com.spring.playerapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.playerapi.exception.PlayerException;
import com.spring.playerapi.model.PlayerError;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler
	public ResponseEntity<PlayerError> getExceptionNotFound(PlayerException pe) {
		PlayerError PlayerError = new PlayerError();
		PlayerError.setStatusCode(HttpStatus.NOT_FOUND.value());
		PlayerError.setMessage(pe.getMessage());
		PlayerError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<PlayerError>(PlayerError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<PlayerError> getException(Exception e) {
		PlayerError PlayerError = new PlayerError();
		PlayerError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		PlayerError.setMessage(e.getMessage());
		PlayerError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<PlayerError>(PlayerError, HttpStatus.BAD_REQUEST);
	}
}

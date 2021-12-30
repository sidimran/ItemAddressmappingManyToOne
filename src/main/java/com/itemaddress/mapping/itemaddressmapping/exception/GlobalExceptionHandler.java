package com.itemaddress.mapping.itemaddressmapping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)

	public ResponseEntity<ErrorMessage> handleItemNotFoundException(ItemNotFoundException exception,
			WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(new Date(), HttpStatus.NOT_FOUND, exception.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AddressNotFoundException.class)

	public ResponseEntity<ErrorMessage> handleAddressNotException(AddressNotFoundException exception,
			WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(new Date(), HttpStatus.NOT_FOUND, exception.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

}

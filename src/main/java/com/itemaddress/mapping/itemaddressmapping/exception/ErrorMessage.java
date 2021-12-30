package com.itemaddress.mapping.itemaddressmapping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	
	private Date timestamp;
	private HttpStatus status;
	private String message;
	private String details;

}

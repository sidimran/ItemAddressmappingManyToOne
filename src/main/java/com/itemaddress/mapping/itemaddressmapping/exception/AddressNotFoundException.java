package com.itemaddress.mapping.itemaddressmapping.exception;

public class AddressNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStacktrace) {
		super(message, cause, enableSuppression, writableStacktrace);
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

}

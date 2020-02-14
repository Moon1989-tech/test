package com.dongwu.demo.service.ex;

public class PhoneNotFoundException extends ServiceException {

	private static final long serialVersionUID = 845900284224517387L;

	public PhoneNotFoundException() {
		super();
	}

	public PhoneNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PhoneNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PhoneNotFoundException(String message) {
		super(message);
	}

	public PhoneNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}

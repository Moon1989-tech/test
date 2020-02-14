package com.dongwu.demo.service.ex;

public class TooManyCodeException extends ServiceException {


	private static final long serialVersionUID = -3194593646906086100L;

	public TooManyCodeException() {
		super();
	}

	public TooManyCodeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TooManyCodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TooManyCodeException(String message) {
		super(message);
	}

	public TooManyCodeException(Throwable cause) {
		super(cause);
	}
	
	
}

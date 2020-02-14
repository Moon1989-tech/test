package com.dongwu.demo.service.ex;

public class TimeTooShortException extends ServiceException {


	private static final long serialVersionUID = 1706751178541686717L;

	public TimeTooShortException() {
		super();
	}

	public TimeTooShortException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TimeTooShortException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeTooShortException(String message) {
		super(message);
	}

	public TimeTooShortException(Throwable cause) {
		super(cause);
	}
	
	
}

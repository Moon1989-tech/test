package com.dongwu.demo.service.ex;

public class CodeNotMatchException extends ServiceException {


	private static final long serialVersionUID = -8216814064152831483L;

	public CodeNotMatchException() {
		super();
	}

	public CodeNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CodeNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodeNotMatchException(String message) {
		super(message);
	}

	public CodeNotMatchException(Throwable cause) {
		super(cause);
	}
	
	
}

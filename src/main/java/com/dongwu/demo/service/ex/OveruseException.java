package com.dongwu.demo.service.ex;

public class OveruseException extends ServiceException {

	private static final long serialVersionUID = 3854942858221879996L;

	public OveruseException() {
		super();
	}

	public OveruseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OveruseException(String message, Throwable cause) {
		super(message, cause);
	}

	public OveruseException(String message) {
		super(message);
	}

	public OveruseException(Throwable cause) {
		super(cause);
	}
	
	
}

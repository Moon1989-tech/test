package com.dongwu.demo.service.ex;

public class OvertimeException extends ServiceException {


	private static final long serialVersionUID = 3763529179358220162L;

	public OvertimeException() {
		super();
	}

	public OvertimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OvertimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public OvertimeException(String message) {
		super(message);
	}

	public OvertimeException(Throwable cause) {
		super(cause);
	}
	
	
}

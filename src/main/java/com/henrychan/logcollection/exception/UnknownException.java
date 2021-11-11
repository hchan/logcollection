package com.henrychan.logcollection.exception;

public class UnknownException extends Exception {
	/**
	 * catch all exception
	 */
	private static final long serialVersionUID = 1L;

	public UnknownException(Exception e) {
		super(e);
	}
}

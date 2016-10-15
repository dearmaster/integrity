package com.mars.tea.springmvc.exception;

public class ResourceUnavailableException extends Exception {

	private static final long serialVersionUID = 7734536964545454757L;
	
	public ResourceUnavailableException() {
		super("The requested resource can't be found");
	}
	
	public ResourceUnavailableException(String msg) {
		super(msg);
	}

}

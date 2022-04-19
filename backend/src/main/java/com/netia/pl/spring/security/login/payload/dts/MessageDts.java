package com.netia.pl.spring.security.login.payload.dts;

public class MessageDts {
	private String message;

	public MessageDts(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

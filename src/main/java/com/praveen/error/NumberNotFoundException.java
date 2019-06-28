package com.praveen.error;

public final class NumberNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String m_bossMessage;
	private Long resourceId;

	public NumberNotFoundException() {
		super();
	}

	public NumberNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NumberNotFoundException(final String message) {
		super(message);
		ExceptionResponse exceptionResponse = new ExceptionResponse(404, message, message);
	}

	public NumberNotFoundException(final Throwable cause) {
		super(cause);
	}

	public NumberNotFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}
	
	 public String getBossMessage()
	   {
	       return m_bossMessage;
	   }
}

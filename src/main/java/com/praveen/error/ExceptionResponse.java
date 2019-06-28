package com.praveen.error;

import com.fasterxml.jackson.annotation.JsonView;

public class ExceptionResponse extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Throwable cause;
	private StackTraceElement[] stackTrace;
	private String localizedMessage;
	private Throwable[] suppressed;
	private String errorCode;
	
	@JsonView(ErrorView.error.class)
	private long timestamp;
	
	@JsonView(ErrorView.error.class)
	private int status;
	
	@JsonView(ErrorView.error.class)
	private String message;

	@JsonView(ErrorView.error.class)
	private String errorMessage;
    
    public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	public void setSuppressed(Throwable[] suppressed) {
		this.suppressed = suppressed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public ExceptionResponse()
	{}
	
	public ExceptionResponse(int status, String errorMessage, String message) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.message = message;
	}

	public ExceptionResponse(int status, String errorMessage, String message,Exception e) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.message = message;
		e.printStackTrace();
	}
	
}

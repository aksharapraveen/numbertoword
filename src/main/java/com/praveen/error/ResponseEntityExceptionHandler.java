package com.praveen.error;

import java.util.Calendar;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonView;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandler {

	public ResponseEntityExceptionHandler() {
		super();
	}

	@JsonView(ErrorView.error.class)
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ExceptionResponse> handleBadRequest(final ConstraintViolationException ex,
			final WebRequest request, ExceptionResponse exceptionResponce) {
		ExceptionResponse response = new ExceptionResponse();
		int statusid=exceptionResponce.getStatus();
		response.setErrorMessage(exceptionResponce.getErrorMessage());
		response.setStatus(statusid);
		response.setMessage(exceptionResponce.getMessage());
		response.setTimestamp(Calendar.getInstance().getTimeInMillis());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.valueOf(statusid) );
	}

	// 500
	@JsonView(ErrorView.error.class)
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<ExceptionResponse> handleInternal(final RuntimeException ex, final WebRequest request,
			ExceptionResponse exceptionResponce) {
		ExceptionResponse response = new ExceptionResponse();
		int statusid=exceptionResponce.getStatus();
		response.setErrorMessage(exceptionResponce.getErrorMessage());
		response.setStatus(statusid);
		response.setMessage(exceptionResponce.getMessage());
		response.setTimestamp(Calendar.getInstance().getTimeInMillis());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.valueOf(statusid) );
	}

	@JsonView(ErrorView.error.class)
	@ExceptionHandler(value = { ExceptionResponse.class })
	protected ResponseEntity<ExceptionResponse> exceptionResponse(final RuntimeException ex, final WebRequest request,
			ExceptionResponse exceptionResponce) {
		int statusid=exceptionResponce.getStatus();
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exceptionResponce.getErrorMessage());
		response.setStatus(statusid);
		response.setMessage(exceptionResponce.getMessage());
		response.setTimestamp(Calendar.getInstance().getTimeInMillis());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.valueOf(statusid) );
	}

}
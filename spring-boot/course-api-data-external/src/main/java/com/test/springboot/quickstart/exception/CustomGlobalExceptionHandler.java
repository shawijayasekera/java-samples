package com.test.springboot.quickstart.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		/*
		 * Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp", new
		 * Date()); body.put("status", status.value());
		 */

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		
		String errorsCommaSeparated = String.join(",", errors);

		/* body.put("errors", errors); */
		
		CommonErrorMessage commonErrorMessage = new CommonErrorMessage();
		RequestError requestError = new RequestError();
		ServiceException serviceException = new ServiceException();
		serviceException.setMessageId("SVC0002");
		serviceException.setText("Invalid input value for message part %1");
		serviceException.setVariables("Missing mandatory parameters: " + errorsCommaSeparated);
		requestError.setServiceException(serviceException);
		commonErrorMessage.setRequestError(requestError);
		
		return new ResponseEntity<>(commonErrorMessage, headers, status);
	}
}

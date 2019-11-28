package com.test.springboot.quickstart.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CommonErrorMessage commonErrorMessage = new CommonErrorMessage();
		RequestError requestError = new RequestError();
		ServiceException serviceException = new ServiceException();

		//Multimap<String, Multimap<String, String>> errorMap = Multimaps.synchronizedMultimap(HashMultimap.create());
		Multimap<String, Multimap<String, String>> errorMap = ArrayListMultimap.create();

		List<FieldError> errorCodes = ex.getBindingResult().getFieldErrors();
		for (FieldError fieldError : errorCodes) {

			String error = fieldError.getCode();
			String errorField = fieldError.getField();
			String rejectedValue = String.valueOf(fieldError.getRejectedValue());

			//Multimap<String, String> innerMap = Multimaps.synchronizedMultimap(HashMultimap.create());
			Multimap<String, String> innerMap = ArrayListMultimap.create();
			innerMap.put(errorField, rejectedValue);
			errorMap.put(error, innerMap);

			System.out.println(rejectedValue);
		}

		@SuppressWarnings("unchecked")
		Collection<Multimap<String, String>> blankMap = errorMap.get("NotBlank");
		
		List<String> blankErrorFieldList = new ArrayList<String>(blankMap.keySet());

		@SuppressWarnings("unchecked")
		Multimap<String, String> nullMap = (Multimap<String, String>) errorMap.get("NotNull");
		List<String> nullErrorFieldList = new ArrayList<String>(nullMap.keySet());

		@SuppressWarnings("unchecked")
		Multimap<String, String> emptyMap = (Multimap<String, String>) errorMap.get("NotEmpty");
		List<String> emptyErrorFieldList = new ArrayList<String>(emptyMap.keySet());

		List<String> missingParameterList = new ArrayList<String>();
		missingParameterList.addAll(blankErrorFieldList);
		missingParameterList.addAll(nullErrorFieldList);
		missingParameterList.addAll(emptyErrorFieldList);

		@SuppressWarnings("unchecked")
		Multimap<String, String> msisdnMap = (Multimap<String, String>) errorMap.get("MSISDN");
		// List<String> msisdnErrorFieldList = new
		// ArrayList<String>(msisdnMap.keySet());
		List<String> msisdnRejectedValueList = new ArrayList<String>(msisdnMap.values());

		@SuppressWarnings("unchecked")
		Multimap<String, String> decimalMinMap = (Multimap<String, String>) errorMap.get("DecimalMin");
		// List<String> decimalMinErrorFieldList = new
		// ArrayList<String>(decimalMinMap.keySet());
		List<String> decimalMinRejectedValueList = new ArrayList<String>(msisdnMap.values());

		if (blankMap.size() > 0 || nullMap.size() > 0 || emptyMap.size() > 0) {

			if (missingParameterList.size() > 1) {

				String errorsCommaSeparated = String.join(",", missingParameterList);

				serviceException.setMessageId("SVC0002");
				serviceException.setText("Invalid input value for message part %1");
				serviceException.setVariables("Missing mandatory parameters: " + errorsCommaSeparated);
			} else {

				serviceException.setMessageId("SVC0002");
				serviceException.setText("Invalid input value for message part %1");
				serviceException.setVariables("Missing mandatory parameter: " + missingParameterList.get(0));
			}
		} else if (msisdnMap.size() > 0) {

			String rejectedMSISDNCommaSeparated = String.join(",", msisdnRejectedValueList);

			serviceException.setMessageId("SVC0004");
			serviceException.setText("No valid addresses provided in message part %1");
			serviceException.setVariables(rejectedMSISDNCommaSeparated);
		} else if (decimalMinMap.size() > 0) {

			String rejectedDecimalMinCommaSeparated = String.join(",", decimalMinRejectedValueList);

			serviceException.setMessageId("SVC0002");
			serviceException.setText("Invalid input value for message part %1");
			serviceException.setVariables(rejectedDecimalMinCommaSeparated);
		}

		requestError.setServiceException(serviceException);
		commonErrorMessage.setRequestError(requestError);

		return new ResponseEntity<>(commonErrorMessage, headers, status);
	}
}

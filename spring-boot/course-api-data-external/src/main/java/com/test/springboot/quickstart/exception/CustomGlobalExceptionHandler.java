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
import com.google.common.collect.Multimap;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// construct exception message object
		CommonErrorMessage commonErrorMessage = new CommonErrorMessage();
		RequestError requestError = new RequestError();
		ServiceException serviceException = new ServiceException();

		// construct Multimap for store errors
		Multimap<String, ErrorDTO> errorMap = ArrayListMultimap.create();

		List<FieldError> errorCodes = ex.getBindingResult().getFieldErrors();
		for (FieldError fieldError : errorCodes) {

			String error = fieldError.getCode();
			String errorField = fieldError.getField();
			String rejectedValue = String.valueOf(fieldError.getRejectedValue());

			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setErrorField(errorField);
			errorDTO.setRejectedValue(rejectedValue);

			errorMap.put(error, errorDTO);
		}

		// collect NotBlank violation errors
		Collection<ErrorDTO> notBlankerrorDTOCollection = errorMap.get("NotBlank");
		List<String> blankErrorFieldList = new ArrayList<String>();
		for (ErrorDTO errorDTO : notBlankerrorDTOCollection) {

			blankErrorFieldList.add(errorDTO.getErrorField());
		}

		// collect NotNull violation errors
		Collection<ErrorDTO> notNullErrorDTOCollection = errorMap.get("NotNull");
		List<String> nullErrorFieldList = new ArrayList<String>();
		for (ErrorDTO errorDTO : notNullErrorDTOCollection) {

			nullErrorFieldList.add(errorDTO.getErrorField());
		}

		// collect NotEmpty violation errors
		Collection<ErrorDTO> notEmptyErrorDTOCollection = errorMap.get("NotEmpty");
		List<String> emptyErrorFieldList = new ArrayList<String>();
		for (ErrorDTO errorDTO : notEmptyErrorDTOCollection) {

			emptyErrorFieldList.add(errorDTO.getErrorField());
		}

		// merge all NotBlank, NotNull and NotEmpty violation error fields to single
		// list
		List<String> missingParameterList = new ArrayList<String>();
		missingParameterList.addAll(blankErrorFieldList);
		missingParameterList.addAll(nullErrorFieldList);
		missingParameterList.addAll(emptyErrorFieldList);

		// collect MSISDN violation errors
		Collection<ErrorDTO> msisdnErrorDTOCollection = errorMap.get("MSISDN");
		List<String> msisdnRejectedValueList = new ArrayList<String>();
		for (ErrorDTO errorDTO : msisdnErrorDTOCollection) {

			msisdnRejectedValueList.add(errorDTO.getRejectedValue());
		}

		// collect DecimalMin violation errors
		Collection<ErrorDTO> decimalMinErrorDTOCollection = errorMap.get("DecimalMin");
		List<String> decimalMinRejectedValueList = new ArrayList<String>();
		for (ErrorDTO errorDTO : decimalMinErrorDTOCollection) {

			decimalMinRejectedValueList.add(errorDTO.getRejectedValue());
		}

		if (notBlankerrorDTOCollection.size() > 0 || notNullErrorDTOCollection.size() > 0
				|| notEmptyErrorDTOCollection.size() > 0) {

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
		} else if (msisdnErrorDTOCollection.size() > 0) {

			String rejectedMSISDNCommaSeparated = String.join(",", msisdnRejectedValueList);

			serviceException.setMessageId("SVC0004");
			serviceException.setText("No valid addresses provided in message part %1");
			serviceException.setVariables(rejectedMSISDNCommaSeparated);
		} else if (decimalMinErrorDTOCollection.size() > 0) {

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

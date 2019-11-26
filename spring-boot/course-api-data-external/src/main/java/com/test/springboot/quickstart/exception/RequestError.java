package com.test.springboot.quickstart.exception;

public class RequestError {

	private ServiceException serviceException;

	public ServiceException getServiceException() {
		return serviceException;
	}

	public void setServiceException(ServiceException serviceException) {
		this.serviceException = serviceException;
	}
}

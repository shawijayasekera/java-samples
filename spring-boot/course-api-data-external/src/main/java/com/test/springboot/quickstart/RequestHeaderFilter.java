package com.test.springboot.quickstart;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RequestHeaderFilter implements Filter {

	@Autowired
	private HeaderDataHolder headerDataHolder;
	
	public RequestHeaderFilter() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*
	     * Log all header parameters
	     * 
		    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		    Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
		   
		    if (headerNames != null) {
		        while (headerNames.hasMoreElements()) {
		            String name = headerNames.nextElement();
		            System.out.println("Header: " + name + " value:" + httpServletRequest.getHeader(name));
		        }
		    }
	    */
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		headerDataHolder.setConsumerKey(httpRequest.getHeader("CONSUMER_KEY"));
		headerDataHolder.setUserId(httpRequest.getHeader("USER_ID"));
		headerDataHolder.setContext(httpRequest.getHeader("CONTEXT"));
		headerDataHolder.setApiVersion(httpRequest.getHeader("API_VERSION"));
		headerDataHolder.setApiName(httpRequest.getHeader("API_NAME"));
		headerDataHolder.setVersion(httpRequest.getHeader("VERSION"));
		headerDataHolder.setResource(httpRequest.getHeader("RESOURCE"));
		headerDataHolder.setHttpMethod(httpRequest.getHeader("HTTP_METHOD"));
		headerDataHolder.setHostName(httpRequest.getHeader("HOST_NAME"));
		headerDataHolder.setApiPublisher(httpRequest.getHeader("API_PUBLISHER"));
		headerDataHolder.setApplicationName(httpRequest.getHeader("APPLICATION_NAME"));
		headerDataHolder.setApplicationId(httpRequest.getHeader("APPLICATION_ID"));
		headerDataHolder.setOperator(httpRequest.getHeader("OPERATOR"));
		headerDataHolder.setRequestId(httpRequest.getHeader("REQUEST_ID"));
		
	    chain.doFilter(request, response);
	}
}

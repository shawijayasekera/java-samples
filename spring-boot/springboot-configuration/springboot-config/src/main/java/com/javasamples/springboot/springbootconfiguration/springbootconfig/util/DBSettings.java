package com.javasamples.springboot.springbootconfiguration.springbootconfig.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/* 
 * This will convert this DBSettings class to spring bean. 
 */
@Configuration
/*
 * Spring will pick the properties from file based on the 'db' prefix
 */
@ConfigurationProperties("db")
public class DBSettings {

	private String connection;
	private String host;
	private int port;

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}

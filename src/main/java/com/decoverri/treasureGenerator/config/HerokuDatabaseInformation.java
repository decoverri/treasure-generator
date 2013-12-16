package com.decoverri.treasureGenerator.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class HerokuDatabaseInformation {

	private final URI database;

	public HerokuDatabaseInformation(String databaseUrl) {
		try {
			this.database = new URI(databaseUrl);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private String[] userInfo() {
		return database.getUserInfo().split(":");
	}

	private String password(String[] userInfo) {
		return userInfo[1];
	}

	private String user(String[] userInfo) {
		return userInfo[0];
	}

	private String mysqlUrl() {
		return "jdbc:postgresql://" + database.getHost() + ":" + database.getPort() + database.getPath();
	}

	public Properties exportToProperties() {
		Properties p = new Properties();
		p.put("hibernate.connection.url", mysqlUrl());

		String[] userInfo = userInfo();
		p.put("hibernate.connection.username", user(userInfo));
		p.put("hibernate.connection.password", password(userInfo));
		return p;
	}
}

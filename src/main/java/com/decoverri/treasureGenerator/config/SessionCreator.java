package com.decoverri.treasureGenerator.config;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SessionCreator {

	@Autowired
	private SessionFactory factory;

	@Bean(destroyMethod = "close")
	@Scope(value = "request", proxyMode = TARGET_CLASS)
	public Session getSession() {
		return factory.openSession();
	}
}

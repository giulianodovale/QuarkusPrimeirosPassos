package org.acme.quarkus.sample;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DataBaseLifeCycle implements QuarkusTestResourceLifecycleManager {
	
	private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:8.0.19");

	@Override
	public Map<String, String> start() {
		MYSQL.start();
		Map<String, String> properties = new HashMap<>();
	
		properties.put("quarkus.datasource.driver", MYSQL.getJdbcUrl());
		properties.put("quarkus.datasource.username", MYSQL.getUsername());
		properties.put("quarkus.datasource.password", MYSQL.getPassword());
	
		return properties;
	}

	@Override
	public void stop() {
		if(MYSQL != null) {
			MYSQL.stop();
		}
	}

}

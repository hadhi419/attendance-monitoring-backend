package com.AttendanceMonitoring.university_attendance_system_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class UniversityAttendanceSystemBackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(UniversityAttendanceSystemBackendApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UniversityAttendanceSystemBackendApplication.class, args);

		Environment env = context.getEnvironment();
		String address = env.getProperty("server.address", "0.0.0.0");
		String port = env.getProperty("server.port", "8080");

		System.out.println("Server configured to listen on: " + address + ":" + port);
	}

	@Bean
	public CommandLineRunner logEnvironment(Environment env) {
		return args -> {
			String address = env.getProperty("server.address", "0.0.0.0");
			String port = env.getProperty("server.port", "8080");

			logger.info("Server configured to listen on: {}:{}", address, port);

			String dbUrl = env.getProperty("DBURL", "NOT SET");
			String user = env.getProperty("USER", "NOT SET");
			String password = env.getProperty("PASSWORD", "NOT SET");

			logger.info("DBURL = {}", dbUrl);
			logger.info("USER = {}", user);
			logger.info("PASSWORD = {}", password.equals("NOT SET") ? "NOT SET" : "******");
		};
	}

}

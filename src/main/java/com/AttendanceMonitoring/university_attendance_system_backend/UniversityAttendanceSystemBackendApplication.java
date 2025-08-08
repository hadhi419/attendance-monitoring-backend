package com.AttendanceMonitoring.university_attendance_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UniversityAttendanceSystemBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UniversityAttendanceSystemBackendApplication.class, args);

		Environment env = context.getEnvironment();
		String address = env.getProperty("server.address", "0.0.0.0");
		String port = env.getProperty("server.port", "8080");

		System.out.println("Server configured to listen on: " + address + ":" + port);
	}

}

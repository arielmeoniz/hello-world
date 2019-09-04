package com.pablo.apirest01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSwaggerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApp.class, args);
	}
}

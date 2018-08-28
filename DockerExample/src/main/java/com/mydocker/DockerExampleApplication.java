package com.mydocker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@EnableCircuitBreaker
@SpringBootApplication
public class DockerExampleApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DockerExampleApplication.class, args);
	}
	
	
}

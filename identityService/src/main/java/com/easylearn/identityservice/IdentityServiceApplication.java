package com.easylearn.identityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IdentityServiceApplication {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(45000);
		SpringApplication.run(IdentityServiceApplication.class, args);
	}

}

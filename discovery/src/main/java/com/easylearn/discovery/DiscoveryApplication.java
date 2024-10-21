package com.easylearn.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.sound.midi.Soundbank;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(
				"Waiting to start discovery"
		);
		Thread.sleep(10000);
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}

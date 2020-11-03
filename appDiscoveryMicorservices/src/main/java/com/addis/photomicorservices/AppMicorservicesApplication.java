package com.addis.photomicorservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class AppMicorservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMicorservicesApplication.class, args);
	}

}

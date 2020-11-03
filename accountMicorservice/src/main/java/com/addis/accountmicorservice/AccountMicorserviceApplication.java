package com.addis.accountmicorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountMicorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountMicorserviceApplication.class, args);
	}

}

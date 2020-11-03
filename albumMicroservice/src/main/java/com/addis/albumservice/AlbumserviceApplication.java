package com.addis.albumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.addis.controller,com.addis.repository,com.addis.service")
public class AlbumserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumserviceApplication.class, args);
	}

}

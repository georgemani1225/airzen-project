package com.geo.airzen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AirzenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirzenApplication.class, args);
	}
}

package com.careerdevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GatewayApplication {

	private static final String MY_API_KEY = "kw9WkUDnlcLiqnobGeDfT9mBiEl0QGxLYs5wLPjS";

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@GetMapping("/apod")
	public APOD apodInfo (RestTemplate restTemplate) {
		String URL = "https://api.nasa.gov/planetary/apod?api_key=" + MY_API_KEY;

		APOD apod = restTemplate.getForObject(URL, APOD.class);

		return apod;

	}

}

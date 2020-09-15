package com.blog.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blog.app.ws.security.AppProperties;

@SpringBootApplication
public class MobileAppWs3Application {

	public static void main(String[] args) {
		System.out.println("INICIO SPRING...");
		//TODO test
		SpringApplication.run(MobileAppWs3Application.class, args);
	}

	

	@Bean
	public SpringApplicationContext springApplicationContext() {
		System.out.println("Bean SpringApplicationContext...");
		return new SpringApplicationContext();
	}
	
	@Bean (name="AppProperties")
	public AppProperties token() {
		System.out.println("Bean AppProperties...");
		return new AppProperties();
	}
	
}

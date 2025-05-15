package com.example.cardatabase2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cardatabase2Application {
	private static final Logger logger = LoggerFactory.getLogger(Cardatabase2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Cardatabase2Application.class, args);
		logger.info("애플리케이션 실행");
	}

}

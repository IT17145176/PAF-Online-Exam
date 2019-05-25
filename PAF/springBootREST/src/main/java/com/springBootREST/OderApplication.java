package com.springBootREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OderApplication.class, args);
	}
}



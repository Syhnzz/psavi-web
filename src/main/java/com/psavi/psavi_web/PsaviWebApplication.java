package com.psavi.psavi_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.psavi")
@EnableJpaRepositories(basePackages = "com.psavi.core.repository")
@EntityScan(basePackages = "com.psavi.core.entity")
public class PsaviWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsaviWebApplication.class, args);
	}

}

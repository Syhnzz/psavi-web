package com.psavi.psavi_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.psavi.core")
@ComponentScan(basePackages = "com.psavi.psavi_web")
@EnableJpaRepositories(basePackages = "com.psavi.core.repository")
@EntityScan(basePackages = "com.psavi.core.entity")
public class PsaviWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsaviWebApplication.class, args);
	}

}

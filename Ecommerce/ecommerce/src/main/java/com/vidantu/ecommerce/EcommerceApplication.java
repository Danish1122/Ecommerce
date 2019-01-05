package com.vidantu.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.vidantu.ecommerce" })
@EnableJpaRepositories({ "com.vidantu.ecommerce.jpa.repositry" })
@PropertySources(value = { @PropertySource("classpath:/application.properties") })
public class EcommerceApplication  extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EcommerceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}


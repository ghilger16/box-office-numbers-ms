package com.boxofficenumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {
		"classpath:application.properties"
})
@EntityScan(basePackages = "com.boxofficenumbers.api.dto")
public class BoxOfficeNumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxOfficeNumbersApplication.class, args);
	}

}

package com.boxofficenumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

@PropertySource(value = {
		"classpath:application.properties"
})
@EntityScan(basePackages = "com.boxofficenumbers.api.dto")
public class BoxOfficeNumbersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxOfficeNumbersApplication.class, args);
	}

}

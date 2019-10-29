package com.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.SwaggerDefinition;

@SpringBootApplication
@SwaggerDefinition
public class Catalog2Application {

	public static void main(String[] args) {
		SpringApplication.run(Catalog2Application.class, args);
		System.out.print("hello spring starter");
	}

}

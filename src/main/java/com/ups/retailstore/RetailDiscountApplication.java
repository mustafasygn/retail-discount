package com.ups.retailstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RetailDiscountApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailDiscountApplication.class, args);
	}

}

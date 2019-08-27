package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan({"controller","service","employee"})
@SpringBootApplication
@EnableSwagger2
public class SpringRestAndDataJpaWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAndDataJpaWithSpringBootApplication.class, args);
	}

}

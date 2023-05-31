package com.ons.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ons.study.controller")
@ComponentScan(basePackages = "com.ons.study.dao")
@ComponentScan(basePackages = "com.ons.study.dto")
@ComponentScan(basePackages = "com.ons.study.service")
@MapperScan(basePackages = "com.ons.study.dao")
public class OnSApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnSApplication.class, args);
	}

}

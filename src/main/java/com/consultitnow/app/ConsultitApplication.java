package com.consultitnow.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ConsultitApplication  { //extends WebSecurityConfigurerAdapter

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ConsultitApplication.class, args);
	
	
	}
}

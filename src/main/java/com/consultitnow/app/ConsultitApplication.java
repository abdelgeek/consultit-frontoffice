package com.consultitnow.app;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.consultitnow.app.service.StorageService;

@SpringBootApplication
public class ConsultitApplication implements CommandLineRunner { // extends
																	// WebSecurityConfigurerAdapter

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ConsultitApplication.class, args);

	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}

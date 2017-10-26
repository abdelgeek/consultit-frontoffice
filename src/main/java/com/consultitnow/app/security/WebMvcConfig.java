package com.consultitnow.app.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	  @Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	      super.addViewControllers(registry);
	 
	      registry.addViewController("/login").setViewName("login.html");
	      registry.addViewController("/logout").setViewName("login.html");
	      
	      registry.addViewController("/index").setViewName("index.html");
	   }
	
	
}

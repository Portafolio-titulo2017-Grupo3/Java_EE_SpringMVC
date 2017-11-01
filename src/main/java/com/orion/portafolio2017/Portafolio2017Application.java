package com.orion.portafolio2017;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Portafolio2017Application extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Portafolio2017Application.class);
    }
	
	public static void main(String[] args) {
		//SpringApplication.run(Portafolio2017Application.class, args).close();
		SpringApplication.run(Portafolio2017Application.class, args);
	}
}

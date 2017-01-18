package org.huyg.springboot_demo.config;

import org.huyg.springboot_demo.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class HelloWebXml extends SpringBootServletInitializer {  
	
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(SampleController.class);  
    } 
  
} 
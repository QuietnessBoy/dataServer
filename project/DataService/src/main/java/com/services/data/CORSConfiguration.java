package com.services.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
         .allowedMethods("*")
         .allowedOrigins("*")
         //.allowedOrigins("http://localhost:8080","http://127.0.0.0.1:8080","http://1872jk0524.iask.in:10680")
         .allowCredentials(true)
         .allowedHeaders("*");
 super.addCorsMappings(registry);
    }
}

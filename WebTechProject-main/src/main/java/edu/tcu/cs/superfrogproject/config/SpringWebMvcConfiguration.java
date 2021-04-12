package edu.tcu.cs.superfrogproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebMvcConfiguration implements WebMvcConfigurer {
    @Value("${fileUploadURL}")
    private String fileDirectory;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/products/**").addResourceLocations("file:" + fileDirectory);
    }



}

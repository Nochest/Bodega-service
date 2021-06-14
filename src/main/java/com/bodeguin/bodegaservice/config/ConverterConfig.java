package com.bodeguin.bodegaservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:application.properties"})
public class ConverterConfig {
  
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
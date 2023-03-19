package com.myjavaapp.myapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {

    @Bean
    public  String getApiPath(){
        return  "/api/";
    }
}

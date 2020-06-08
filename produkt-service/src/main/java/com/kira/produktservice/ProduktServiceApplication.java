package com.kira.produktservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProduktServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduktServiceApplication.class, args);
    }

    @Bean
    public RestTemplate erhaltenRestTemplate(){
        return new RestTemplate();
    }
}

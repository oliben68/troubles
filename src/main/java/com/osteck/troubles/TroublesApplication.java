package com.osteck.troubles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TroublesApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TroublesApplication.class);
        ConfigurableApplicationContext context = springApplication.run(args);
        Environment env = context.getEnvironment();
    }
}

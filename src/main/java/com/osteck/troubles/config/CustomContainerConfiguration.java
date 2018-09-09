package com.osteck.troubles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomContainerConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    private ApiInformation apiInformation;

    @Autowired
    public CustomContainerConfiguration(ApiInformation apiInformation) {
        this.apiInformation = apiInformation;
    }

    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setContextPath(apiInformation.basePath());
    }
}
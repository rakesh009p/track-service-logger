package com.stackroute.trackservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@ConfigurationProperties(prefix = "app")
@Profile("dev")
public class DBConfiguration {
    private String driverClassName;
    private String url;

    @Bean
    public String developDbConfiguraton() {
        System.out.println("DEV-DB-H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "Data Base Connection for h2";
    }
}

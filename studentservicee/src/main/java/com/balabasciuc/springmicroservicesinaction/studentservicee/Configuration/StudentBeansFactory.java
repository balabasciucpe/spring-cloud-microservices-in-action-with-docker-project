package com.balabasciuc.springmicroservicesinaction.studentservicee.Configuration;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class StudentBeansFactory {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver()
    {
        return new KeycloakSpringBootConfigResolver();
    }

    @Autowired
    public KeycloakClientRequestFactory keycloakClientRequestFactory;

    @Bean
    @LoadBalanced
    @Primary
    public KeycloakRestTemplate keycloakRestTemplate()
    {
        return new KeycloakRestTemplate(keycloakClientRequestFactory);
    }


}

package com.balabasciuc.springmicroservicesinaction.studentservice.Configuration;

import com.balabasciuc.springmicroservicesinaction.studentservice.Model.Facultate;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentProxy {

    private KeycloakRestTemplate restTemplate;

    public StudentProxy(KeycloakRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "studentServicee", fallbackMethod = "fallBackHere")
    @Bulkhead(name ="bulkheadStudentService", fallbackMethod = "defaultBulkhead", type = Bulkhead.Type.THREADPOOL)
    @Retry(name = "retryStudentService", fallbackMethod = "retryFallBackMethod")
    public Facultate getFacultate(String facultateId) throws Exception {
        return restTemplate.getForObject("http://facultate-service:1002/facultate/"  +facultateId, Facultate.class);
    }

    private Facultate fallBackHere(String facultateId, Throwable t)
    {
        return new Facultate("IE", "abc", 8F, null);
    }

    private Facultate defaultBulkhead(String facultateId, Throwable t)
    {
        return new Facultate("IE", "abc", 8F, null);
    }

    private Facultate retryFallBackMethod(String facultateId, Throwable t)
    {
        return new Facultate("IE", "abc", 8F, null);
    }
}

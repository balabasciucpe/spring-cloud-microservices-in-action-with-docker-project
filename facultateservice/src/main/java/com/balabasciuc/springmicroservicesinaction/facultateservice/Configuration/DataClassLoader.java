package com.balabasciuc.springmicroservicesinaction.facultateservice.Configuration;

import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.Facultate;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Repository.FacultateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataClassLoader implements ApplicationRunner {

    private FacultateRepository facultateRepository;

    @Autowired
    public DataClassLoader(FacultateRepository facultateRepository) {
        this.facultateRepository = facultateRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        facultateRepository.save(new Facultate("IE", "Some description", 7.9f));
        facultateRepository.save(new Facultate("EA", "Some description", 5.9f));
        facultateRepository.save(new Facultate("AC", "Some description", 9.9f));
    }
}

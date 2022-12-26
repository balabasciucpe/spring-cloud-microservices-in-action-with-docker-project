package com.balabasciuc.springmicroservicesinaction.facultateservice.Service;

import com.balabasciuc.springmicroservicesinaction.facultateservice.Events.Source.SimpleSourceBean;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.ActionEnum;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.Facultate;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Repository.FacultateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultateService {

    private static Logger logger = LoggerFactory.getLogger(FacultateService.class);

    @Autowired
    private SimpleSourceBean simpleSourceBean;

    private FacultateRepository facultateRepository;

    public FacultateService(FacultateRepository facultateRepository) {
        this.facultateRepository = facultateRepository;
    }


    public void save(Facultate facultate) {
        facultateRepository.save(facultate);
        simpleSourceBean.publishFacultateChange(ActionEnum.CREATED.toString(), facultate.getFacultateNameId());
    }

    public Facultate getById(String facultateNameId) {
        simpleSourceBean.publishFacultateChange("GET", facultateNameId);
        return facultateRepository.findFacultateByFacultateNameId(facultateNameId);

    }
}

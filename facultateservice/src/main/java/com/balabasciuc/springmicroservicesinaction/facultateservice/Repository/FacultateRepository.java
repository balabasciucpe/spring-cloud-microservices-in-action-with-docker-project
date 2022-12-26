package com.balabasciuc.springmicroservicesinaction.facultateservice.Repository;

import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.Facultate;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.StudentName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultateRepository extends JpaRepository<Facultate, Long> {

    Facultate findFacultateByFacultateNameId(String facultateNameId);

}

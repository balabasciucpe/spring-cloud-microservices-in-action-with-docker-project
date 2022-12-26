package com.balabasciuc.springmicroservicesinaction.facultateservice.Controller;

import com.balabasciuc.springmicroservicesinaction.facultateservice.Model.Facultate;
import com.balabasciuc.springmicroservicesinaction.facultateservice.Service.FacultateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/facultate")
public class FacultateController {

    private FacultateService facultateService;

    public FacultateController(FacultateService facultateService) {
        this.facultateService = facultateService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping(value = "/post")
    public ResponseEntity postFacultate(@RequestBody Facultate facultate) {
        facultateService.save(facultate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RolesAllowed("ADMIN")
    @PostMapping(value = "/")
    public String save(@RequestBody Facultate facultate)
    {
        facultateService.save(facultate);
        return "da";
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody Facultate facultate)
    {
        facultateService.save(facultate);
        return "da";
    }

    @GetMapping(value = "/{facultateNameId}")
    public ResponseEntity<Facultate> findById(@PathVariable("facultateNameId") String facultateNameId)
    {
        return new ResponseEntity<>(facultateService.getById(facultateNameId), HttpStatus.ACCEPTED);
    }

    @RolesAllowed("USER")
    @GetMapping(value = "/hi")
    public String sal()
    {
        return "merge";
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping(value = "/test")
    public String test()
    {
        return "merge";
    }

    @RolesAllowed({"ADMIN" , "USER"})
    @GetMapping(value = "/test2")
    public String test2()
    {
        return "merge";
    }

    @RolesAllowed("ADMIN")
    @GetMapping(value = "/test3")
    public String test3()
    {
        return "merge";
    }


}

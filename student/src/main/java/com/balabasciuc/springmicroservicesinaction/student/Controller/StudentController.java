package com.balabasciuc.springmicroservicesinaction.student.Controller;


import com.balabasciuc.springmicroservicesinaction.student.Model.CompoundDTO;
import com.balabasciuc.springmicroservicesinaction.student.Model.Student;
import com.balabasciuc.springmicroservicesinaction.student.Service.StudentService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping(value = "/create")
    public ResponseEntity createStudent2(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @RolesAllowed("USER")
    @PostMapping(value = "/")
    public ResponseEntity createStudent(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping(value = "/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable ("studentId") Long studentId)
    {
        return new ResponseEntity<>(studentService.findStudent(studentId), HttpStatus.ACCEPTED);
    }

    @RolesAllowed({"ADMIN"})
    @SneakyThrows
    @GetMapping(path = "/studentAndFacultate/{studentId}")
    public ResponseEntity<CompoundDTO> getCompund(@PathVariable ("studentId") Long studentId) throws Exception {
        return new ResponseEntity<CompoundDTO>(studentService.getCompound(studentId), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getBy/{facultateId}")
    public ResponseEntity<Student> getByFacultateId(@PathVariable ("facultateId") String facultateId) throws Exception {
        return new ResponseEntity<>(studentService.findByFacultateId(facultateId), HttpStatus.OK);
    }

    @RolesAllowed("USER")
    @GetMapping(value = "/test")
    public String test()
    {
        return "sal user";
    }

    @RolesAllowed("ADMIN")
    @GetMapping(value = "/test2")
    public String hei()
    {
        return "sal admin";
    }
}

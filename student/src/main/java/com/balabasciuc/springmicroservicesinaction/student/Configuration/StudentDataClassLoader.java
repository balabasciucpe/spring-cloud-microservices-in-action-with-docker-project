package com.balabasciuc.springmicroservicesinaction.student.Configuration;

import com.balabasciuc.springmicroservicesinaction.student.Model.Student;
import com.balabasciuc.springmicroservicesinaction.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataClassLoader implements ApplicationRunner {

    private StudentRepository studentRepository;

    @Autowired
    public StudentDataClassLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        studentRepository.save(new Student("IE", 1L, "Test A", "Test B"));
        studentRepository.save(new Student("AC", 3L, "Some name", "ETCCCC"));

    }
}

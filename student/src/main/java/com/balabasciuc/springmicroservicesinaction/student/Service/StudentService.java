package com.balabasciuc.springmicroservicesinaction.student.Service;

import com.balabasciuc.springmicroservicesinaction.student.Configuration.StudentProxy;
import com.balabasciuc.springmicroservicesinaction.student.Model.CompoundDTO;
import com.balabasciuc.springmicroservicesinaction.student.Model.Facultate;
import com.balabasciuc.springmicroservicesinaction.student.Model.Student;
import com.balabasciuc.springmicroservicesinaction.student.Repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentProxy studentProxy;

    public StudentService(StudentRepository studentRepository, StudentProxy studentProxy) {
        this.studentRepository = studentRepository;
        this.studentProxy = studentProxy;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student findStudent(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

    public CompoundDTO getCompound(Long studentId) throws Exception {
        Student student = findStudent(studentId);
        Facultate facultate = apelam(student.getFacultateId());
        return new CompoundDTO(student, facultate);
    }

    private Facultate apelam(String facultateId) throws Exception {
        return studentProxy.getFacultate(facultateId);
    }

    @CircuitBreaker(name = "studentService", fallbackMethod = "buildFallBackFindByFacultateId")
    public Student findByFacultateId(String facultateId) throws TimeoutException {
        randomlyRunLong();
        return studentRepository.findStudentByFacultateId(facultateId);
    }

    private Student buildFallBackFindByFacultateId(String facultateId, Throwable t)
    {
        Student student = new Student();
        student.setCaminId(1L);
        student.setFacultateId(facultateId);
        student.setStudentName("default name");
        student.setStudentPrename("default prename");
        return student;
    }


    private void randomlyRunLong() throws TimeoutException {
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1 ) + 1) + 1;
        if (randomNum == 3) {
            sleep();
        }
    }

    private void sleep() throws TimeoutException {
        try {
            Thread.sleep(5000);
            throw new TimeoutException();
        } catch (InterruptedException e) {
            System.out.println("heh " + e.getMessage());
        }
    }
}

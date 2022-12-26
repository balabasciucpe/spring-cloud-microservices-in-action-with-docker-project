package com.balabasciuc.springmicroservicesinaction.studentservice.Repository;

import com.balabasciuc.springmicroservicesinaction.studentservice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByFacultateId(String facultateId);

}

package com.balabasciuc.springmicroservicesinaction.student.Repository;

import com.balabasciuc.springmicroservicesinaction.student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByFacultateId(String facultateId);

}

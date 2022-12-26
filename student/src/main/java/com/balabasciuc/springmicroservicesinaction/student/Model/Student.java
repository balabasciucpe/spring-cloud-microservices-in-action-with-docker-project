package com.balabasciuc.springmicroservicesinaction.student.Model;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long studentId;
    private String facultateId;
    private Long caminId;
    private String studentName;
    private String studentPrename;

    public Student() {}

    public Student(String facultateId, Long caminId, String studentName, String studentPrename) {
        this.facultateId = facultateId;
        this.caminId = caminId;
        this.studentName = studentName;
        this.studentPrename = studentPrename;
    }

    public Long getStudentId() {
        return studentId;
    }



    public String getFacultateId() {
        return facultateId;
    }

    public void setFacultateId(String facultateId) {
        this.facultateId = facultateId;
    }

    public Long getCaminId() {
        return caminId;
    }

    public void setCaminId(Long caminId) {
        this.caminId = caminId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPrename() {
        return studentPrename;
    }

    public void setStudentPrename(String studentPrename) {
        this.studentPrename = studentPrename;
    }
}

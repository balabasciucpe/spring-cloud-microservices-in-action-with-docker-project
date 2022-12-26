package com.balabasciuc.springmicroservicesinaction.facultateservice.Model;


import javax.persistence.Embeddable;

@Embeddable
public class StudentName {

    private String studentName;
    private Long studentAge;

    public StudentName(String studentName, Long studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public StudentName() {}

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(Long studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentAge() {
        return studentAge;
    }
}

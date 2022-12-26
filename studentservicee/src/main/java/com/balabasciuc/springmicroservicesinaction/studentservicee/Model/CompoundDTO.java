package com.balabasciuc.springmicroservicesinaction.studentservicee.Model;

import lombok.Data;

@Data
public class CompoundDTO {

    private Student student;
    private Facultate facultate;

    public CompoundDTO(Student student, Facultate facultate) {
        this.student = student;
        this.facultate = facultate;
    }

    public CompoundDTO() {}
}


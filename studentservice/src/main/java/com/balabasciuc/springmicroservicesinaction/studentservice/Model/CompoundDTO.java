package com.balabasciuc.springmicroservicesinaction.studentservice.Model;

import lombok.AllArgsConstructor;
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


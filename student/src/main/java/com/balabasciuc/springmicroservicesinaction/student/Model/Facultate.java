package com.balabasciuc.springmicroservicesinaction.student.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Facultate {


    protected Facultate() {}

    private String facultateNameId;
    private String facultateDescription;
    private Float minimumNote;
    private List<String> students;

    public Facultate(String facultateNameId, String facultateDescription, Float minimumNote, List<String> students) {
        this.facultateNameId = facultateNameId;
        this.facultateDescription = facultateDescription;
        this.minimumNote = minimumNote;
        this.students = students;
    }
}

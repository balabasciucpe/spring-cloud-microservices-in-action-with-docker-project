package com.balabasciuc.springmicroservicesinaction.facultateservice.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Facultate {

    @Id
    private String facultateNameId;
    private String facultateDescription;
    private Float minimumNote;


    public Facultate() {}

    public Facultate(String facultateNameId, String facultateDescription, Float minimumNote) {
        this.facultateNameId = facultateNameId;
        this.facultateDescription = facultateDescription;
        this.minimumNote = minimumNote;
    }

    public void setFacultateNameId(String facultateNameId) {
        this.facultateNameId = facultateNameId;
    }

    public String getFacultateNameId() {
        return facultateNameId;
    }

    public String getFacultateDescription() {
        return facultateDescription;
    }

    public void setFacultateDescription(String facultateDescription) {
        this.facultateDescription = facultateDescription;
    }

    public Float getMinimumNote() {
        return minimumNote;
    }

    public void setMinimumNote(Float minimumNote) {
        this.minimumNote = minimumNote;
    }


}

package com.balabasciuc.springmicroservicesinaction.student.Handler;

public class FacultateChangeModel {

    private String type;
    private String action;
    private String facultateId;


    public FacultateChangeModel() {}

    public FacultateChangeModel(String type, String action, String facultateId) {
        this.type = type;
        this.action = action;
        this.facultateId = facultateId;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFacultateId() {
        return facultateId;
    }

    public void setFacultateId(String facultateId) {
        this.facultateId = facultateId;
    }




    @Override
    public String toString() {
        return "FacultateChangeModel{" +
                "type='" + type + '\'' +
                ", action='" + action + '\'' +
                ", facultateId='" + facultateId + '\'' +
                '}';
    }
}

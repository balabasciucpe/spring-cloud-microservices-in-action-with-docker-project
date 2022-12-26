package com.balabasciuc.springmicroservicesinaction.studentservice.Events.Handler;

public class FacultateChangeModel {

    private String type;
    private String action;
    private String facultateId;
    private String correlationId;

    public FacultateChangeModel(String type, String action, String facultateId, String correlationId) {
        this.type = type;
        this.action = action;
        this.facultateId = facultateId;
        this.correlationId = correlationId;
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

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Override
    public String toString() {
        return "FacultateChangeModel{" +
                "type='" + type + '\'' +
                ", action='" + action + '\'' +
                ", facultateId='" + facultateId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }
}

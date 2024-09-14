package com.example.consumer.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private Integer iD;
    private String name;
    private String email;
    private String statusMessage;

    public Integer getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}

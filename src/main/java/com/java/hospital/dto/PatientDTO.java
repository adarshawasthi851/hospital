package com.java.hospital.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDTO {
    private String name;
    private Integer age;
    private Date admitDate;
    private String status; //discharge, admitted
    private String roomNumber;
    private Integer expenses;
    private String doctorName;
    private String addharNumber; // or any other Unique identification  number




}

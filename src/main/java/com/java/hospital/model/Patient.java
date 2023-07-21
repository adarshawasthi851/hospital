package com.java.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient  extends AuditModel{

    @Column(name= "name")
    private String name;

    @Column(name= "age")
    private Integer age;

    @Column(name= "room_number")
    private String roomNumber;

    @Column(name= "doctor_name")
    private String doctorName;

    @Column(name= "expenses")
    private Integer expenses;

    @Column(name= "status")
    private String status;

    @Column(name= "admitted_date")
    private Date admittedDate;

    @Column(name= "addhar_number")
    private String addharNumber;



}

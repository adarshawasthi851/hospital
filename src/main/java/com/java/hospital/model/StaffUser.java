package com.java.hospital.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "staff_user")
public class StaffUser extends AuditModel {
    private String name;
    private String email;
    private String username;
    private String password; // this will be encrypted
    private String role;
}

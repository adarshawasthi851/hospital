package com.java.hospital.dto;

import lombok.Data;

@Data
public class StaffUserSignupDTO {

    private String email;
    private String username;
    private String password;
    private String name;
    private String role;
    private String age;
}

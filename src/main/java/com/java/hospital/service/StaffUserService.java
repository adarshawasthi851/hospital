package com.java.hospital.service;

import com.java.hospital.dto.StaffUserSignupDTO;
import com.java.hospital.model.StaffUser;
import com.java.hospital.repository.StaffUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffUserService {

    @Autowired
    StaffUserRepository staffUserRepository;

    public StaffUser signupUser(StaffUserSignupDTO staffUser) {

        StaffUser newUser = new StaffUser();
        newUser.setEmail(staffUser.getEmail());
        newUser.setName(staffUser.getName());
        newUser.setUsername(staffUser.getUsername());
        newUser.setPassword(staffUser.getPassword());
        newUser.setRole(staffUser.getRole());
        return staffUserRepository.save(newUser);
    }


}

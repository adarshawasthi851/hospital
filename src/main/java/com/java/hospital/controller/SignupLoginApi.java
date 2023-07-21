package com.java.hospital.controller;

import com.java.hospital.dto.StaffUserLoginDTO;
import com.java.hospital.dto.StaffUserSignupDTO;
import com.java.hospital.model.StaffUser;
import com.java.hospital.repository.StaffUserRepository;
import com.java.hospital.service.StaffUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hospital/staff_user/")
public class SignupLoginApi {

    private final String secretKey = "yourSecretKey";

    @Autowired
    StaffUserRepository staffUserRepository;

    @Autowired
    StaffUserService staffUserService;


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody StaffUserSignupDTO staffUser) {
        // Check if the username is already taken
        if (staffUserRepository.findByUsername(staffUser.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already taken.");
        }

        // Save the new staff user to the database
        StaffUser user = staffUserService.signupUser(staffUser);
        if(user!=null){
            return ResponseEntity.ok("Signup successful.");
        }
        else{
            return ResponseEntity.internalServerError().build();
        }

    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody StaffUserLoginDTO staffUser) {
        // Find the staff user by username
        StaffUser existingUser = staffUserRepository.findByUsername(staffUser.getUsername());

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message", "Invalid username."));
        }

        // Check if the entered password matches the stored password
        if (!existingUser.getPassword().equals(staffUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message", "Invalid password."));
        }

        String token = generateJwtToken(staffUser.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful.");
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
    private String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token expiration time (24 hours)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}

package com.java.hospital.controller;

import com.java.hospital.dto.PatientDTO;
import com.java.hospital.model.Patient;
import com.java.hospital.repository.PatientRepository;
import com.java.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/api/patient")
public class PatientApi {



    @Autowired
    PatientService patientService;

    // API to admit new  patient which takes PatientDTO and required info to admit
    @PostMapping("/admit")
    public ResponseEntity<String> admitPatient(@RequestBody PatientDTO patient) {
        patientService.admitNewPatient(patient);
        return ResponseEntity.ok("Patient admitted successfully.");
    }

    // API to fetch all patient from table patient
    @GetMapping("/all_patients")
    public ResponseEntity<List<Patient>> getAllPatients() {

        List<Patient> patients = patientService.findAllPatient();
        return ResponseEntity.ok(patients);
    }
    @PostMapping("/patients/{patientId}/discharge")
    public ResponseEntity<String> dischargePatient(@PathVariable Integer patientId) {
        return patientService.dischargePatient(patientId);
    }



}

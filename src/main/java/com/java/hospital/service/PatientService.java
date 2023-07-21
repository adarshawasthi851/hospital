package com.java.hospital.service;

import com.java.hospital.Enums.PatientEnum;
import com.java.hospital.dto.PatientDTO;
import com.java.hospital.model.Patient;
import com.java.hospital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void admitNewPatient(PatientDTO patient){
        Patient newPatient = new Patient();
        newPatient.setAge(patient.getAge());
        newPatient.setName(patient.getName());
        newPatient.setAdmittedDate(patient.getAdmitDate());
        newPatient.setStatus("Admitted");
        newPatient.setExpenses(patient.getExpenses());
        newPatient.setRoomNumber(patient.getRoomNumber());
        newPatient.setDoctorName(patient.getDoctorName());
        newPatient.setAddharNumber(patient.getAddharNumber());
        patientRepository.save(newPatient);
    }

    public ResponseEntity<String> dischargePatient(Integer patientId) {

        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patient.setStatus(PatientEnum.DISCHARGED.toString());
            patientRepository.save(patient);
            return ResponseEntity.ok("Patient discharged successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}

package com.java.hospital.repository;

import com.java.hospital.model.StaffUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;

@Repository
public interface StaffUserRepository extends JpaRepository<StaffUser, Integer> {
    StaffUser findByUsername(String username);
}

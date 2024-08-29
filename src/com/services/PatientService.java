package com.services;

import com.model.Patient;

import java.util.List;

public interface PatientService {

    void addPatient(Patient patient);
    void deletePatient(int id);
    List<Patient> getPatients();
    void updatePatient(Patient patient,int id);
}

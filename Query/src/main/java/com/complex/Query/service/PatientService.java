package com.complex.Query.service;

import com.complex.Query.dto.PatientDTO;
import com.complex.Query.model.Patient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {
  // Retrieve all patients
  Flux<PatientDTO> getAllPatients();

  // Retrieve a patient by its ID
  Mono<PatientDTO> getPatientById(Long id);

  Mono<PatientDTO> createPatient(PatientDTO patientDTO);

  // Update an existing patient
  Mono<PatientDTO> updatePatient(Long id, PatientDTO patientDTO);

  // Delete a patient by its ID
  Mono<Void> deletePatient(Long id);

  // Complex query: find patients by their last name
  Flux<PatientDTO> findPatientsByLastName(String lastName);
}

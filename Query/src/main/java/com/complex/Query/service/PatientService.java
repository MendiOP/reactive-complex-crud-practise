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

  // Complex queries to practise; :)
  Flux<PatientDTO> searchPatientsByLastName(String lastName);
  Flux<PatientDTO> getPatientsLastNameAndFirstName(String firstName, String lastName);
  Flux<PatientDTO> getPatientsStateWithSameLastName(String state, String lastName);
  Flux<PatientDTO> getPatientsFromD1toD2(String date1, String date2);
  Flux<PatientDTO> getPatientsBySearch(String city, String state, String gender, String fromDate, String toDate);
}

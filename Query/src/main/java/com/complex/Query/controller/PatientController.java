package com.complex.Query.controller;

import com.complex.Query.dto.PatientDTO;
import com.complex.Query.model.Patient;
import com.complex.Query.repository.PatientRepository;
import com.complex.Query.service.PatientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/patient")
public class PatientController {
  private final PatientService patientService;

  // Constructor injection of the service
  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  // Retrieve all patients
  @GetMapping
  public Flux<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  // Retrieve a patient by ID
  @GetMapping("/{id}")
  public Mono<PatientDTO> getPatientById(@PathVariable Long id) {
    return patientService.getPatientById(id);
  }

  // Create a new patient
  @PostMapping
  public Mono<PatientDTO> createPatient(@RequestBody Patient patient) {
    return patientService.createPatient(patient);
  }

  // Update an existing patient
  @PutMapping("/{id}")
  public Mono<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
    return patientService.updatePatient(id, patient);
  }

  // Delete a patient by ID
  @DeleteMapping("/{id}")
  public Mono<Void> deletePatient(@PathVariable Long id) {
    return patientService.deletePatient(id);
  }

  // Complex query endpoint: find patients by last name
  @GetMapping("/search/by-lastname")
  public Flux<PatientDTO> findPatientsByLastName(@RequestParam String lastName) {
    return patientService.findPatientsByLastName(lastName);
  }

  // Example of a complex query endpoint (if you have defined one in the repository)
  // @GetMapping("/search/upcoming")
  // public Flux<Patient> findPatientsWithUpcomingAppointments(@RequestParam String date) {
  //     LocalDate appointmentDate = LocalDate.parse(date);
  //     return patientRepository.findPatientsWithUpcomingAppointments(appointmentDate);
  // }
}

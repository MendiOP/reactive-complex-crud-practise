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
  public Flux<PatientDTO> getAllPatients() {
    return patientService.getAllPatients();
  }

  // Retrieve a patient by ID
  @GetMapping("/{id}")
  public Mono<PatientDTO> getPatientById(@PathVariable Long id) {
    return patientService.getPatientById(id);
  }

  // Create a new patient
  @PostMapping
  public Mono<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
    return patientService.createPatient(patientDTO);
  }

  // Update an existing patient
  @PutMapping("/{id}")
  public Mono<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
    return patientService.updatePatient(id, patientDTO);
  }

  // Delete a patient by ID
  @DeleteMapping("/{id}")
  public Mono<Void> deletePatient(@PathVariable Long id) {
    return patientService.deletePatient(id);
  }

  // Complex query endpoint: find patients by last name
  @GetMapping("/search/l")
  public Flux<PatientDTO> findPatientsByLastName(@RequestParam("lastname") String lastName) {
    return patientService.searchPatientsByLastName(lastName);
  }

  @GetMapping("/search/f")
  public Flux<PatientDTO> getPatientsWithLastNameAndFirstName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
    return patientService.getPatientsLastNameAndFirstName(firstName, lastName);
  }

  @GetMapping("/search/al")
  public Flux<PatientDTO> getPatientsAddressWithSameLastName(@RequestParam("state") String state, @RequestParam("lastName") String lastName) {
    return patientService.getPatientsStateWithSameLastName(state, lastName);
  }

  @GetMapping("/dob")
  public Flux<PatientDTO> getPatientsFromD1toD2(@RequestParam("from") String date1, @RequestParam("to") String date2) {
//    System.out.println(date1 + " " + date2);
    return patientService.getPatientsFromD1toD2(date1, date2);
  }
}

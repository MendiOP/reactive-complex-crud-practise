package com.complex.Query.repository;

import com.complex.Query.model.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
  // Simple custom query: find patients by last name
  Flux<Patient> findByLastName(String lastName);

  // Example of a complex query using @Query (uncomment and adjust for your DB dialect)
  // @Query("SELECT p.* FROM patients p JOIN appointments a ON p.patient_id = a.patient_id WHERE a.appointment_date > :date")
  // Flux<Patient> findPatientsWithUpcomingAppointments(LocalDate date);
}

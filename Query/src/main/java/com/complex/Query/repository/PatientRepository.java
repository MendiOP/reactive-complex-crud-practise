package com.complex.Query.repository;

import com.complex.Query.model.Patient;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
  // Simple custom query: find patients by last name
  @Query(value = "select * from patient where last_name=:lastName")
  Flux<Patient> getPatientsLastName(String lastName);


  @Query(value="select * from patient where first_name=:firstName and last_name=:lastName")
  Flux<Patient> getPatientsLastNameAndFirstName(String firstName, String lastName);

  @Query(value="select * from patient where state=:state and last_name=:lastName")
  Flux<Patient> getPatientsStateWithSameLastName(String state, String lastName);
}

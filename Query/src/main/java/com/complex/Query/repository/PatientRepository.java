package com.complex.Query.repository;

import com.complex.Query.model.Patient;
import com.complex.Query.model.Prescription;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {

  @Query(value = "select * from patient where last_name=:lastName")
  Flux<Patient> getPatientsLastName(String lastName);


  @Query(value="select * from patient where first_name=:firstName and last_name=:lastName")
  Flux<Patient> getPatientsLastNameAndFirstName(String firstName, String lastName);

  @Query(value="select * from patient where state=:state and last_name=:lastName")
  Flux<Patient> getPatientsStateWithSameLastName(String state, String lastName);


  //get data from d1 to d2
  @Query("SELECT * " +
      "FROM patient " +
      "WHERE STR_TO_DATE(date_of_birth, '%d-%m-%Y') > STR_TO_DATE(:date1, '%d-%m-%Y') " +
      "AND STR_TO_DATE(date_of_birth, '%d-%m-%Y') < STR_TO_DATE(:date2, '%d-%m-%Y')")
  Flux<Patient> getPatientsFromD1toD2(@RequestParam("from") String date1, @RequestParam("to") String date2);


  //query to fetch data from multiple or single criteria
  @Query("SELECT *\n"
      + "FROM patient\n"
      + "WHERE \n"
      + "    (:city IS NULL OR city = :city)\n"
      + "    AND (:state IS NULL OR state = :state)\n"
      + "    AND (:gender IS NULL OR gender = :gender)\n"
      + "    AND (\n"
      + "         (:fromDate IS NULL OR STR_TO_DATE(date_of_birth, '%d-%m-%Y') >= STR_TO_DATE(:fromDate, '%d-%m-%Y'))\n"
      + "         AND (:toDate IS NULL OR STR_TO_DATE(date_of_birth, '%d-%m-%Y') <= STR_TO_DATE(:toDate, '%d-%m-%Y'))\n"
      + "    )\n")
  Flux<Patient> getPatientsBySearch(String city, String state, String gender, String fromDate, String toDate);

  //all prescriptions for a Patient
  @Query("SELECT * FROM prescription WHERE patient_id = :id")
  Flux<Prescription> getAllPrescriptionsByPatient(Long id);
}

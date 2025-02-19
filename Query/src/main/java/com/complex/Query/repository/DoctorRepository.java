package com.complex.Query.repository;

import com.complex.Query.dto.PatientDTO;
import com.complex.Query.model.Doctor;
import com.complex.Query.model.Patient;
import java.util.List;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DoctorRepository extends ReactiveCrudRepository<Doctor, Long> {
  //doctors who had patients
  @Query("select distinct doctor_id from prescription")
  Flux<Long> getDoctorsWhoHadPatient();

  @Query("SELECT p.* \n"
      + "FROM patient p\n"
      + "JOIN patientdoctor pd ON p.patient_id = pd.patient_id\n"
      + "WHERE pd.doctor_id = :doctorId")
  Flux<Patient> getAllPatientsByDoctorId(Long doctorId);
}

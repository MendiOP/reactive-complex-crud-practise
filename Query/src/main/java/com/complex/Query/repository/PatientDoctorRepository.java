package com.complex.Query.repository;

import com.complex.Query.model.PatientDoctor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDoctorRepository extends ReactiveCrudRepository<PatientDoctor, Long> {

}

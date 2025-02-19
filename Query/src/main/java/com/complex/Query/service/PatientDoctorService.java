package com.complex.Query.service;

import com.complex.Query.dto.PatientDoctorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientDoctorService {
  Flux<PatientDoctorDTO> getAllPatientWithDoctors();
  Mono<PatientDoctorDTO> addPatientWithDoctor(PatientDoctorDTO patientDoctorDTO);
}

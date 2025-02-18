package com.complex.Query.service.impl;

import com.complex.Query.dto.PatientDTO;
import com.complex.Query.model.Patient;
import com.complex.Query.repository.PatientRepository;
import com.complex.Query.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService {

  private final PatientRepository patientRepository;
  private final ModelMapper modelMapper;
  public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
    this.patientRepository = patientRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public Flux<Patient> getAllPatients() {
    return patientRepository.findAll();
  }

  @Override
  public Mono<PatientDTO> getPatientById(Long id) {
    return null;
  }

  @Override
  public Mono<PatientDTO> createPatient(Patient patient) {
    return null;
  }

  @Override
  public Mono<PatientDTO> updatePatient(Long id, Patient patient) {
    return null;
  }

  @Override
  public Mono<Void> deletePatient(Long id) {
    return null;
  }

  @Override
  public Flux<PatientDTO> findPatientsByLastName(String lastName) {
    return null;
  }
}

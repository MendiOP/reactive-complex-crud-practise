package com.complex.Query.service.impl;

import com.complex.Query.dto.PatientDoctorDTO;
import com.complex.Query.model.PatientDoctor;
import com.complex.Query.repository.PatientDoctorRepository;
import com.complex.Query.service.PatientDoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientDoctorServiceImpl implements PatientDoctorService {

  private final PatientDoctorRepository patientDoctorRepository;
  private final ModelMapper modelMapper;
  public PatientDoctorServiceImpl(PatientDoctorRepository patientDoctorRepository, ModelMapper modelMapper) {
    this.patientDoctorRepository = patientDoctorRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Flux<PatientDoctorDTO> getAllPatientWithDoctors() {
    Flux<PatientDoctor> all = patientDoctorRepository.findAll();
    return all.map(patientDoctor -> modelMapper.map(patientDoctor, PatientDoctorDTO.class));
  }

  @Override
  public Mono<PatientDoctorDTO> addPatientWithDoctor(PatientDoctorDTO patientDoctorDTO) {

    PatientDoctor map = modelMapper.map(patientDoctorDTO, PatientDoctor.class);
    return patientDoctorRepository.save(map).map(
        patientDoctor -> modelMapper.map(patientDoctor, PatientDoctorDTO.class));
  }
}

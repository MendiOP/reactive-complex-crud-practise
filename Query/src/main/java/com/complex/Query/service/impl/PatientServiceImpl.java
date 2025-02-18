package com.complex.Query.service.impl;

import com.complex.Query.dto.PatientDTO;
import com.complex.Query.model.Patient;
import com.complex.Query.repository.PatientRepository;
import com.complex.Query.service.PatientService;
import org.modelmapper.ModelMapper;
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
  public Flux<PatientDTO> getAllPatients() {
    return patientRepository.findAll()
        .map( patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Mono<PatientDTO> getPatientById(Long id) {

    Mono<Patient> byId = patientRepository.findById(id);
    return byId.map(patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Mono<PatientDTO> createPatient(PatientDTO patientDTO) {
    Patient map = modelMapper.map(patientDTO, Patient.class);
    return patientRepository.save(map).map( patient -> modelMapper.map(patient, PatientDTO.class));
  }


  @Override
  public Mono<PatientDTO> updatePatient(Long id, PatientDTO patientDTO) {

    Mono<Patient> byId = patientRepository.findById(id);
    Patient updatedPatient = modelMapper.map(patientDTO, Patient.class);

    Mono<Patient> patientMono = byId.flatMap(patient -> {
      patient.setAddress(updatedPatient.getAddress());
      patient.setCity(updatedPatient.getCity());
      patient.setCountry(updatedPatient.getCountry());
      patient.setEmail(updatedPatient.getEmail());
      patient.setGender(updatedPatient.getGender());
      patient.setFirstName(updatedPatient.getFirstName());
      patient.setLastName(updatedPatient.getLastName());
      patient.setContactNumber(updatedPatient.getContactNumber());
      patient.setDateOfBirth(updatedPatient.getDateOfBirth());
      patient.setZip(updatedPatient.getZip());
      patient.setState(updatedPatient.getState());

      return patientRepository.save(patient);
    });

    return patientMono.map(patient -> modelMapper.map(patient, PatientDTO.class));
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

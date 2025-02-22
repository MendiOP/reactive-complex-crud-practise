package com.complex.Query.service.impl;

import static org.modelmapper.Converters.Collection.map;

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

    return patientRepository
        .findById(id)
        .flatMap(patient -> {
              modelMapper.map(patientDTO, patient);
              return patientRepository.save(patient);
              })
        .map(patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Mono<Void> deletePatient(Long id) {
    return null;
  }

  @Override
  public Flux<PatientDTO> searchPatientsByLastName(String lastName) {
    Flux<Patient> patientsLastName = patientRepository.getPatientsLastName(lastName);

    return patientsLastName.map(
        patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Flux<PatientDTO> getPatientsLastNameAndFirstName(String firstName, String lastName) {

    Flux<Patient> patientsLastNameAndFirstName = patientRepository.getPatientsLastNameAndFirstName(
        firstName, lastName);

    return patientsLastNameAndFirstName.map(patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Flux<PatientDTO> getPatientsStateWithSameLastName(String state, String lastName) {

    Flux<Patient> patientsAddressWithSameLastName = patientRepository.getPatientsStateWithSameLastName(
        state, lastName);

    return patientsAddressWithSameLastName.map(patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Flux<PatientDTO> getPatientsFromD1toD2(String date1, String date2) {
    Flux<Patient> patientsFromD1toD2 = patientRepository.getPatientsFromD1toD2(date1, date2);
    return patientsFromD1toD2.map(patient -> modelMapper.map(patient, PatientDTO.class));
//    return null;
  }

  @Override
  public Flux<PatientDTO> getPatientsBySearch(String city, String state, String gender, String fromDate, String toDate) {

    Flux<Patient> patientsFromTopStates = patientRepository.getPatientsBySearch(city, state, gender, fromDate, toDate);
    return patientsFromTopStates.map(patient -> modelMapper.map(patient, PatientDTO.class));
  }

  @Override
  public Flux<PatientDTO> getPrescriptionsByPatient(Long id) {
    return patientRepository.getAllPrescriptionsByPatient(id)
        .map(prescription -> modelMapper.map(prescription, PatientDTO.class));
  }
}

package com.complex.Query.service.impl;

import com.complex.Query.dto.DoctorDTO;
import com.complex.Query.model.Doctor;
import com.complex.Query.repository.DoctorRepository;
import com.complex.Query.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepository doctorRepository;
  private final ModelMapper modelMapper;

  public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
    this.doctorRepository = doctorRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public Mono<DoctorDTO> createDoctor(DoctorDTO doctorDTO) {
    Doctor map = modelMapper.map(doctorDTO, Doctor.class);
    return doctorRepository.save(map).map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
  }

  @Override
  public Mono<DoctorDTO> updateDoctor(DoctorDTO doctorDTO, Long id) {
    Doctor map = modelMapper.map(doctorDTO, Doctor.class);
    Mono<Doctor> byId = doctorRepository.findById(id);

    return byId.flatMap(doctor -> {
      doctor.setContactNumber(map.getContactNumber());
      doctor.setEmail(map.getEmail());
      doctor.setFirstName(map.getFirstName());
      doctor.setLastName(map.getLastName());
      doctor.setSpecialty(map.getSpecialty());
      return doctorRepository.save(doctor);
    }).map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
  }

  @Override
  public Mono<Void> deleteDoctor(Long id) {
    return doctorRepository.deleteById(id);
  }

  @Override
  public Mono<DoctorDTO> getDoctor(Long id) {
    return doctorRepository.findById(id).map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
  }

  @Override
  public Flux<DoctorDTO> getAllDoctors() {
    return doctorRepository.findAll().map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
  }
}

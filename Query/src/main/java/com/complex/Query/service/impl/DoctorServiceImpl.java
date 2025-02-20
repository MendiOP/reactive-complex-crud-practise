package com.complex.Query.service.impl;

import com.complex.Query.dto.DoctorDTO;
import com.complex.Query.dto.PatientDTO;
import com.complex.Query.dto.PrescriptionDTO;
import com.complex.Query.model.Doctor;
import com.complex.Query.repository.DoctorRepository;
import com.complex.Query.repository.PrescriptionRepository;
import com.complex.Query.service.DoctorService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepository doctorRepository;
  private final PrescriptionRepository prescriptionRepository;
  private final ModelMapper modelMapper;

  public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper, PrescriptionRepository prescriptionRepository) {
    this.doctorRepository = doctorRepository;
    this.modelMapper = modelMapper;
    this.prescriptionRepository = prescriptionRepository;
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
      modelMapper.map(doctorDTO, doctor);
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

  @Override
  public Flux<DoctorDTO> getDoctorsWhoHadPatients() {

    Flux<Long> doctorsWhoHadPatient = doctorRepository.getDoctorsWhoHadPatient();
    Flux<Doctor> doctorFlux = doctorsWhoHadPatient
        .flatMap(doctorRepository::findById);

    return doctorFlux.map(doctor -> modelMapper.map(doctor, DoctorDTO.class));
  }

  @Override

  //getting all the patients with their prescriptions that is given by a specific doctor
  public Flux<PatientDTO> getAllPatientsByDoctorId(Long doctorId) {
    return doctorRepository.getAllPatientsByDoctorId(doctorId)
        .flatMap(patient ->
            prescriptionRepository.findByPatientIdAndDoctorId(patient.getPatientId(), doctorId)
                .collectList()
                .map(prescriptions -> {
                  PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);

                  List<PrescriptionDTO> prescriptionDTOs = prescriptions.stream()
                      .map(prescription -> modelMapper.map(prescription, PrescriptionDTO.class))
                      .collect(Collectors.toList());

                  patientDTO.setPrescriptions(prescriptionDTOs);
                  return patientDTO;
                })
                .doOnNext(dto -> System.out.println("Patient " + dto.getFirstName()
                    + " has " + dto.getPrescriptions().size() + " prescriptions."))
        );
  }

}

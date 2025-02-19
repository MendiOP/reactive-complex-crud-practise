package com.complex.Query.service.impl;

import com.complex.Query.dto.PrescriptionDTO;
import com.complex.Query.model.Prescription;
import com.complex.Query.repository.PrescriptionRepository;
import com.complex.Query.service.PrescriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

  private final PrescriptionRepository prescriptionRepository;
  private final ModelMapper modelMapper;

  public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, ModelMapper modelMapper) {
    this.prescriptionRepository = prescriptionRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Mono<PrescriptionDTO> addPrescription(PrescriptionDTO prescriptionDTO) {

    return prescriptionRepository
        .save(modelMapper.map(prescriptionDTO, Prescription.class))
        .map(prescription -> modelMapper.map(prescription, PrescriptionDTO.class));
  }

  @Override
  public Flux<PrescriptionDTO> getAllPrescriptions() {

    return prescriptionRepository
        .findAll()
        .map(prescription -> modelMapper.map(prescription, PrescriptionDTO.class));
  }

  @Override
  public Mono<PrescriptionDTO> getPrescriptionById(Long id) {
    return prescriptionRepository
        .findById(id)
        .map(prescription -> modelMapper.map(prescription, PrescriptionDTO.class));
  }

  @Override
  public Mono<Void> deletePrescriptionById(Long id) {
    return prescriptionRepository
        .deleteById(id);
  }

  @Override
  public Mono<PrescriptionDTO> updatePrescription(PrescriptionDTO prescriptionDTO, Long id) {

    Mono<Prescription> byId = prescriptionRepository
        .findById(id);

    Prescription map = modelMapper.map(prescriptionDTO, Prescription.class);

    return byId.flatMap(prescription -> {
      prescription.setDatePrescribed(map.getDatePrescribed());
      prescription.setDoctorId(map.getDoctorId());
      prescription.setDosage(map.getDosage());
      prescription.setDuration(map.getDuration());
      prescription.setInstructions(map.getInstructions());
      prescription.setFrequency(map.getFrequency());
      prescription.setMedicationName(map.getMedicationName());
      prescription.setPatientId(map.getPatientId());
      prescription.setRefillInfo(map.getRefillInfo());

      return prescriptionRepository.save(prescription);
    }).map(prescription -> modelMapper.map(prescription, PrescriptionDTO.class));
  }
}

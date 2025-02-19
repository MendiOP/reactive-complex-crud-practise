package com.complex.Query.service;

import com.complex.Query.dto.PrescriptionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrescriptionService {
  Mono<PrescriptionDTO> addPrescription(PrescriptionDTO prescriptionDTO);
  Flux<PrescriptionDTO> getAllPrescriptions();
  Mono<PrescriptionDTO> getPrescriptionById(Long id);
  Mono<Void> deletePrescriptionById(Long id);
  Mono<PrescriptionDTO> updatePrescription(PrescriptionDTO prescriptionDTO, Long id);
}

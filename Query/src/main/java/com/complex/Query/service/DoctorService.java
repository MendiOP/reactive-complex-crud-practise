package com.complex.Query.service;

import com.complex.Query.dto.DoctorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorService {
  Mono<DoctorDTO> createDoctor(DoctorDTO doctorDTO);
  Mono<DoctorDTO> updateDoctor(DoctorDTO doctorDTO, Long id);
  Mono<Void> deleteDoctor(Long id);
  Mono<DoctorDTO> getDoctor(Long id);
  Flux<DoctorDTO> getAllDoctors();
}

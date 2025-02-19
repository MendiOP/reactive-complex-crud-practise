package com.complex.Query.controller;

import com.complex.Query.dto.PatientDoctorDTO;
import com.complex.Query.service.PatientDoctorService;
import com.complex.Query.service.impl.PatientDoctorServiceImpl;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/assign")
public class PatientDoctorController {

  private final PatientDoctorServiceImpl patientDoctorService;
  public PatientDoctorController(PatientDoctorServiceImpl patientDoctorService) {
    this.patientDoctorService = patientDoctorService;
  }

  @GetMapping("/all")
  public Flux<PatientDoctorDTO> getPatientDoctors() {
    return patientDoctorService.getAllPatientWithDoctors();
  }

  @PostMapping()
  public Mono<PatientDoctorDTO> createPatientDoctor(@RequestBody PatientDoctorDTO patientDoctorDTO) {
    return patientDoctorService.addPatientWithDoctor(patientDoctorDTO);
  }
}

package com.complex.Query.controller;

import com.complex.Query.dto.DoctorDTO;
import com.complex.Query.dto.PatientDTO;
import com.complex.Query.service.impl.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

  private final DoctorServiceImpl doctorService;

  public DoctorController(DoctorServiceImpl doctorService) {
    this.doctorService = doctorService;
  }

  @GetMapping
  public Mono<ResponseEntity<List<DoctorDTO>>> getDoctors() {
    return doctorService.getAllDoctors()
        .collectList()
        .map(doctors -> ResponseEntity.ok(doctors));
  }

  @PostMapping
  public Mono<ResponseEntity<DoctorDTO>> createDoctor(@RequestBody DoctorDTO doctorDTO) {
    return doctorService.createDoctor(doctorDTO)
        .map(createdDoctor -> ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor))
        .defaultIfEmpty(ResponseEntity.noContent().build());
  }

  @GetMapping("/id/{id}")
  public Mono<ResponseEntity<DoctorDTO>> getDoctorById(@PathVariable Long id) {
    return doctorService.getDoctor(id)
        .map(doctor -> ResponseEntity.ok(doctor))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PutMapping("/update/{id}")
  public Mono<ResponseEntity<DoctorDTO>> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
    return doctorService.updateDoctor(doctorDTO, id)
        .map(updatedDoctor -> ResponseEntity.ok(updatedDoctor))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/delete/{id}")
  public Mono<ResponseEntity<Void>> deleteDoctor(@PathVariable Long id) {
    return doctorService.deleteDoctor(id)
        .then(Mono.just(ResponseEntity.noContent().build()));
  }

  //custom apis
  @GetMapping("/have/patients")
  public Mono<ResponseEntity<List<DoctorDTO>>> getAllDoctorsWhoHadPatients() {
    return doctorService
        .getDoctorsWhoHadPatients()
        .collectList()
        .map(doctorDTO -> ResponseEntity.ok(doctorDTO));
  }

  @GetMapping("/allpatients/{id}")
  public Mono<ResponseEntity<List<PatientDTO>>> getAllDoctorsForAPatient(@PathVariable Long id) {
    return doctorService.getAllPatientsByDoctorId(id)
        .collectList()
        .map(doctorDTO -> ResponseEntity.ok(doctorDTO));
  }
}

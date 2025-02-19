package com.complex.Query.controller;

import com.complex.Query.dto.PrescriptionDTO;
import com.complex.Query.service.impl.PrescriptionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
  private final PrescriptionServiceImpl prescriptionService;

  public PrescriptionController(PrescriptionServiceImpl prescriptionService) {
    this.prescriptionService = prescriptionService;
  }

  @GetMapping
  public Mono<ResponseEntity<List<PrescriptionDTO>>> getAllPrescriptions() {
    return prescriptionService.getAllPrescriptions()
        .collectList()
        .map(prescriptions -> ResponseEntity.ok(prescriptions));
  }

  @PostMapping
  public Mono<ResponseEntity<PrescriptionDTO>> createPrescription(@RequestBody PrescriptionDTO prescriptionDTO) {
    return prescriptionService.addPrescription(prescriptionDTO)
        .map(savedPrescription -> ResponseEntity.status(HttpStatus.CREATED).body(savedPrescription));
  }

  @GetMapping("/id/{id}")
  public Mono<ResponseEntity<PrescriptionDTO>> getPrescriptionById(@PathVariable Long id) {
    return prescriptionService.getPrescriptionById(id)
        .map(prescription -> ResponseEntity.ok(prescription))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PutMapping("/update/{id}")
  public Mono<ResponseEntity<PrescriptionDTO>> updatePrescription(@PathVariable Long id, @RequestBody PrescriptionDTO prescriptionDTO) {
    return prescriptionService.updatePrescription(prescriptionDTO, id)
        .map(updatedPrescription -> ResponseEntity.ok(updatedPrescription))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/delete/{id}")
  public Mono<ResponseEntity<Void>> deletePrescription(@PathVariable Long id) {
    return prescriptionService.deletePrescriptionById(id)
        .then(Mono.just(ResponseEntity.noContent().build()));
  }
}

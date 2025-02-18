package com.complex.Query.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionDTO{
  private Long patientId;
  private Long doctorId;
  private String medicationName;
  private String dosage;
  private String frequency;
  private String duration;
  private String instructions;
  private LocalDate datePrescribed;
  private String refillInfo;
}

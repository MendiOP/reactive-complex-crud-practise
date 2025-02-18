package com.complex.Query.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecordDTO{
  private Long recordId;
  private Long patientId;
  private LocalDate recordDate;
  private String treatment;
  private String diagnosis;
  private String labResults;
  private String notes;
  private Long doctorId;
}

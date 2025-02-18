package com.complex.Query.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("prescription")
public class Prescription {

  @Id
  private Long prescriptionId;

  // Foreign key to Patient
  private Long patientId;

  // Foreign key to doctor
  private Long doctorId;
  private String medicationName;
  private String dosage;
  private String frequency;
  private String duration;
  private String instructions;
  private LocalDate datePrescribed;
  private String refillInfo;


}

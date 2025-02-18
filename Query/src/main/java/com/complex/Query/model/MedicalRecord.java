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
@Table("medicalrecord")
public class MedicalRecord {

  @Id
  private Long recordId;

  //foreign key from patient
  private Long patientId;
  private LocalDate recordDate;
  private String treatment;
  private String diagnosis;
  private String labResults;
  private String notes;

  //foreign key from doctor
  private Long doctorId;
}

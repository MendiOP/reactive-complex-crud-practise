package com.complex.Query.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("patientdoctor")
public class PatientDoctor {
  @Id
  private Long pdId;

  //foreign keys
  @Column("doctor_id")
  private Long doctorId;
  @Column("patient_id")
  private Long patientId;

  public PatientDoctor(Long pdId, Long doctorId, Long patientId) {
    this.pdId = pdId;
    this.doctorId = doctorId;
    this.patientId = patientId;
  }

  public PatientDoctor() {
  }

  public Long getPdId() {
    return pdId;
  }

  public void setPdId(Long pdId) {
    this.pdId = pdId;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }
}

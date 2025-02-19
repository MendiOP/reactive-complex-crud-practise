package com.complex.Query.dto;

import org.springframework.data.relational.core.mapping.Column;

public class PatientDoctorDTO {

  private Long pdId;
  private Long doctorId;
  private Long patientId;

  public PatientDoctorDTO() {
  }

  public PatientDoctorDTO(Long pdId, Long doctorId, Long patientId) {
    this.pdId = pdId;
    this.doctorId = doctorId;
    this.patientId = patientId;
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

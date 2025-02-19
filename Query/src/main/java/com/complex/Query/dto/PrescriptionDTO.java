package com.complex.Query.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


public class PrescriptionDTO{
  private Long prescriptionId;
  private Long patientId;
  private Long doctorId;
  private String medicationName;
  private String dosage;
  private String frequency;
  private String duration;
  private String instructions;
  private LocalDate datePrescribed;
  private String refillInfo;

  public PrescriptionDTO() {
  }

  public PrescriptionDTO(Long prescriptionId, Long patientId, Long doctorId, String medicationName, String dosage,
      String frequency, String duration, String instructions, LocalDate datePrescribed,
      String refillInfo) {
    this.prescriptionId = prescriptionId;
    this.patientId = patientId;
    this.doctorId = doctorId;
    this.medicationName = medicationName;
    this.dosage = dosage;
    this.frequency = frequency;
    this.duration = duration;
    this.instructions = instructions;
    this.datePrescribed = datePrescribed;
    this.refillInfo = refillInfo;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Long getPrescriptionId() {
    return prescriptionId;
  }

  public void setPrescriptionId(Long prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public String getMedicationName() {
    return medicationName;
  }

  public void setMedicationName(String medicationName) {
    this.medicationName = medicationName;
  }

  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public LocalDate getDatePrescribed() {
    return datePrescribed;
  }

  public void setDatePrescribed(LocalDate datePrescribed) {
    this.datePrescribed = datePrescribed;
  }

  public String getRefillInfo() {
    return refillInfo;
  }

  public void setRefillInfo(String refillInfo) {
    this.refillInfo = refillInfo;
  }
}

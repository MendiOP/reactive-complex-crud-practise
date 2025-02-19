package com.complex.Query.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("doctor")
public class Doctor {
  @Id
  @Column("doctor_id")
  private Long doctorId;

  @Column("first_name")
  private String firstName;

  @Column("last_name")
  private String lastName;
  private String specialty;

  @Column("contact_number")
  private String contactNumber;
  private String email;

  public Doctor() {
  }

  public Doctor(Long doctorId, String firstName, String lastName, String specialty,
      String contactNumber, String email) {
    this.doctorId = doctorId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.specialty = specialty;
    this.contactNumber = contactNumber;
    this.email = email;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

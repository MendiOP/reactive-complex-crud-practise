package com.complex.Query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class PatientDTO {
  private Long patientId;
  private String firstName;
  private String lastName;
  private String gender;
  private String dateOfBirth;
  private String address;
  private String city;
  private String state;
  private String zip;
  private String contactNumber;
  private String email;
  private String country;
}

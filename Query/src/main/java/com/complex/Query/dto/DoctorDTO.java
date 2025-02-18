package com.complex.Query.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorDTO{
  private Long doctorId;
  private String firstName;
  private String lastName;
  private String specialty;
  private String contactNumber;
  private String email;
}

package com.complex.Query.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("patient")
public class Patient{
  @Id
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

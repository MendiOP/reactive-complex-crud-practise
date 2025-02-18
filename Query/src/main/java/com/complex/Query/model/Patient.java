package com.complex.Query.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("patient")
public class Patient{
  @Id
  @Column("patient_id")
  private Long patientId;

  @Column("first_name")
  private String firstName;

  @Column("last_name")
  private String lastName;
  private String gender;

  @Column("date_of_birth")
  private String dateOfBirth;
  private String address;
  private String city;
  private String state;
  private String zip;

  @Column("contact_number")
  private String contactNumber;
  private String email;
  private String country;
}

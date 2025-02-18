package com.complex.Query.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDTO {
  private Long appointmentId;
  private Long patientId;
  private Long doctorId;
  private LocalTime appointmentTime;
  private LocalDate appointmentDate;
  private String reasonForVisit;
  private String comment;
}

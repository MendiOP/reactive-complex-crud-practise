package com.complex.Query.model;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("appointment")
public class Appointment{
    @Id
    private Long appointmentId;

    //foreign key to connect p&a
    private Long patientId;

    //foreign key to connect p&d
    private Long doctorId;
    private LocalTime appointmentTime;
    private LocalDate appointmentDate;
    private String reasonForVisit;
    private String comment;
}

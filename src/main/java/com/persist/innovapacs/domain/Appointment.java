package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class Appointment {
    String id;
    Patient patient;
    Physician physician;
    LocalDate appointmentDate;
    LocalTime appointmentTime;
    String purpose;
    String status;
    String controlNumber;
    LocalDate creationDate;
    String address;
    String city;
    String state;
    String postalCode;
    String country;
}

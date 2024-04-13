package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Physician {
    String id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String gender;
    String specialization;
    String documentId;
    String phoneNumber;
    String address;
    String city;
    String state;
    String postalCode;
    String country;
}

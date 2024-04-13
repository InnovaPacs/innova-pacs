package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class Patient {
    String id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String gender;
    String documentId;
    String phoneNumber;
    String address;
    String city;
    String state;
    String ssn;
    String postalCode;
    String country;
    String notes;
    String maritalStatus;
    String emergencyContact;

    User user;
}

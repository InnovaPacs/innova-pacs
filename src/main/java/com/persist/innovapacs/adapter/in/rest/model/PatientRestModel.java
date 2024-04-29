package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.persist.innovapacs.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class PatientRestModel {
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
    UserRestModel user;

    public static PatientRestModel fromDomain(Patient patient) {

        if (patient == null) return null;

        return PatientRestModel.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .documentId(patient.getDocumentId())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .city(patient.getCity())
                .state(patient.getState())
                .postalCode(patient.getPostalCode())
                .country(patient.getCountry())
                .notes(patient.getNotes())
                .maritalStatus(patient.getMaritalStatus())
                .user(UserRestModel.fromDomain(patient.getUser()))
                .emergencyContact(patient.getEmergencyContact())
                .build();
    }

    public static Patient toDomain(PatientRestModel patientRestModel) {
        return Patient.builder()
                .id(patientRestModel.getId())
                .firstName(patientRestModel.getFirstName())
                .lastName(patientRestModel.getLastName())
                .dateOfBirth(patientRestModel.getDateOfBirth())
                .gender(patientRestModel.getGender())
                .documentId(patientRestModel.getDocumentId())
                .phoneNumber(patientRestModel.getPhoneNumber())
                .address(patientRestModel.getAddress())
                .city(patientRestModel.getCity())
                .state(patientRestModel.getState())
                .postalCode(patientRestModel.getPostalCode())
                .country(patientRestModel.getCountry())
                .notes(patientRestModel.getNotes())
                .maritalStatus(patientRestModel.getMaritalStatus())
                .emergencyContact(patientRestModel.getEmergencyContact())
                .build();
    }
}

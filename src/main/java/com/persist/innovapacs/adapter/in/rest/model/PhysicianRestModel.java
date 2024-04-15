package com.persist.innovapacs.adapter.in.rest.model;

import com.persist.innovapacs.domain.Physician;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PhysicianRestModel {
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

    public static PhysicianRestModel fromDomain(Physician physician) {

        if (physician == null) return null;

        return PhysicianRestModel.builder()
                .id(physician.getId())
                .firstName(physician.getFirstName())
                .lastName(physician.getLastName())
                .dateOfBirth(physician.getDateOfBirth())
                .gender(physician.getGender())
                .documentId(physician.getDocumentId())
                .phoneNumber(physician.getPhoneNumber())
                .address(physician.getAddress())
                .city(physician.getCity())
                .state(physician.getState())
                .postalCode(physician.getPostalCode())
                .country(physician.getCountry())
                .build();
    }

    public static Physician toDomain(PhysicianRestModel patientRestModel) {
        return Physician.builder()
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
                .build();
    }
}

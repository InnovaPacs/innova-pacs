package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class PatientEntity {
    @Id()
    String id;
    @Column(name = "document_id", unique = true)
    String documentId;
    @Column(name = "ssn")
    String ssn;
    @Column(name = "emergency_contact")
    String emergencyContact;
    @Column(name = "notes")
    String notes;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column
    String address;
    @Column
    String city;
    @Column
    String state;
    @Column(name = "postal_code")
    String postalCode;
    @Column
    String country;

    @Column(name = "first_name", length = 50)
    String firstName;
    @Column(name = "last_name", length = 50)
    String lastName;
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;
    @Column(name = "gender")
    String gender;
    @Column(name = "marital_status")
    String maritalStatus;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "medical_office_id", referencedColumnName = "id")
    private MedicalOfficeEntity medicalOffice;

    public static Patient toDomain(PatientEntity patient) {
        return Patient.builder()
                .id(patient.getId())
                .documentId(patient.getDocumentId())
                .ssn(patient.getSsn())
                .emergencyContact(patient.getEmergencyContact())
                .notes(patient.getNotes())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .city(patient.getCity())
                .state(patient.getState())
                .postalCode(patient.getPostalCode())
                .country(patient.getCountry())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .maritalStatus(patient.getMaritalStatus())
                .user(UserEntity.toDomain(patient.getUser()))
                .build();
    }
}
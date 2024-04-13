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

        if (patient == null) return null;

        return Patient.builder()
                .id(patient.getId())
                .documentId(patient.getDocumentId())
                .emergencyContact(patient.getEmergencyContact())
                .country(patient.getCountry())
                .city(patient.getCity())
                .notes(patient.getNotes())
                .state(patient.getState())
                .ssn(patient.getSsn())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .address(patient.getAddress())
                .maritalStatus(patient.getMaritalStatus())
                .phoneNumber(patient.getPhoneNumber())
                .postalCode(patient.getPostalCode())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .build();
    }

    public static PatientEntity fromDomain(Patient patient) {

        if (patient == null) return null;

        return PatientEntity.builder()
                .id(patient.getId())
                .documentId(patient.getDocumentId())
                .emergencyContact(patient.getEmergencyContact())
                .country(patient.getCountry())
                .city(patient.getCity())
                .notes(patient.getNotes())
                .state(patient.getState())
                .ssn(patient.getSsn())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .address(patient.getAddress())
                .maritalStatus(patient.getMaritalStatus())
                .phoneNumber(patient.getPhoneNumber())
                .postalCode(patient.getPostalCode())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .build();
    }

    public static PatientEntity patchEntity(Patient patient, PatientEntity currentPatient) {
        return PatientEntity.builder()
                .id(patient.getId())
                .documentId(patient.getDocumentId() != null ? patient.getDocumentId() : currentPatient.getDocumentId())
                .emergencyContact(patient.getEmergencyContact() != null ? patient.getEmergencyContact() : currentPatient.getEmergencyContact())
                .country(patient.getCountry() != null ? patient.getCountry() : currentPatient.getCountry())
                .city(patient.getCity() != null ? patient.getCity() : currentPatient.getCity())
                .notes(patient.getNotes() != null ? patient.getNotes() : currentPatient.getNotes())
                .state(patient.getState() != null ? patient.getState() : currentPatient.getState())
                .ssn(patient.getSsn() != null ? patient.getSsn() : currentPatient.getSsn())
                .dateOfBirth(patient.getDateOfBirth() != null ? patient.getDateOfBirth() : currentPatient.getDateOfBirth())
                .gender(patient.getGender() != null ? patient.getGender() : currentPatient.getGender())
                .address(patient.getAddress() != null ? patient.getAddress() : currentPatient.getAddress())
                .maritalStatus(patient.getMaritalStatus() != null ? patient.getMaritalStatus() : currentPatient.getMaritalStatus())
                .phoneNumber(patient.getPhoneNumber() != null ? patient.getPhoneNumber() : currentPatient.getPhoneNumber())
                .postalCode(patient.getPostalCode() != null ? patient.getPostalCode() : currentPatient.getPostalCode())
                .firstName(patient.getFirstName() != null ? patient.getFirstName() : currentPatient.getFirstName())
                .lastName(patient.getLastName() != null ? patient.getLastName() : currentPatient.getLastName())
                .build();
    }
}
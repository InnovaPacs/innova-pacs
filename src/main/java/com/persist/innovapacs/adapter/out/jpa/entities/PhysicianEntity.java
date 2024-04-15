package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.Physician;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "physicians")
public class PhysicianEntity {
    @Id()
    String id;
    @Column(name = "document_id", unique = true)
    String documentId;
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
    @Column
    String specialization;;
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
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToMany
    @JoinTable(name = "physician_medical_office",
            joinColumns = @JoinColumn(name = "physician_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_office_id"))
    private Set<MedicalOfficeEntity> medicalOffices;

    public static Physician toDomain(PhysicianEntity physician) {

        if (physician == null) return null;

        return Physician.builder()
                .id(physician.getId())
                .documentId(physician.getDocumentId())
                .country(physician.getCountry())
                .city(physician.getCity())
                .state(physician.getState())
                .dateOfBirth(physician.getDateOfBirth())
                .gender(physician.getGender())
                .address(physician.getAddress())
                .phoneNumber(physician.getPhoneNumber())
                .postalCode(physician.getPostalCode())
                .firstName(physician.getFirstName())
                .lastName(physician.getLastName())
                .specialization(physician.getSpecialization())
                .build();
    }

    public static PhysicianEntity fromDomain(Physician physician) {

        if (physician == null) return null;

        return PhysicianEntity.builder()
                .id(physician.getId())
                .documentId(physician.getDocumentId())
                .country(physician.getCountry())
                .city(physician.getCity())
                .state(physician.getState())
                .dateOfBirth(physician.getDateOfBirth())
                .gender(physician.getGender())
                .address(physician.getAddress())
                .phoneNumber(physician.getPhoneNumber())
                .postalCode(physician.getPostalCode())
                .firstName(physician.getFirstName())
                .lastName(physician.getLastName())
                .specialization(physician.getSpecialization())
                .build();
    }

    public static PhysicianEntity patchEntity(Physician physician, PhysicianEntity currentPhysician) {
        return PhysicianEntity.builder()
                .id(physician.getId())
                .documentId(physician.getDocumentId() != null ? physician.getDocumentId() : currentPhysician.getDocumentId())
                .country(physician.getCountry() != null ? physician.getCountry() : currentPhysician.getCountry())
                .city(physician.getCity() != null ? physician.getCity() : currentPhysician.getCity())
                .state(physician.getState() != null ? physician.getState() : currentPhysician.getState())
                .dateOfBirth(physician.getDateOfBirth() != null ? physician.getDateOfBirth() : currentPhysician.getDateOfBirth())
                .gender(physician.getGender() != null ? physician.getGender() : currentPhysician.getGender())
                .address(physician.getAddress() != null ? physician.getAddress() : currentPhysician.getAddress())
                .phoneNumber(physician.getPhoneNumber() != null ? physician.getPhoneNumber() : currentPhysician.getPhoneNumber())
                .postalCode(physician.getPostalCode() != null ? physician.getPostalCode() : currentPhysician.getPostalCode())
                .firstName(physician.getFirstName() != null ? physician.getFirstName() : currentPhysician.getFirstName())
                .lastName(physician.getLastName() != null ? physician.getLastName() : currentPhysician.getLastName())
                .specialization(physician.getSpecialization() != null ? physician.getSpecialization() : currentPhysician.getSpecialization())
                .build();
    }
}

package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.MedicalOffice;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "medical_offices")
public class MedicalOfficeEntity {
    @Id()
    String id;
    @Column(length = 50)
    String name;
    @Column
    String image;
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
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToMany(mappedBy = "medicalOffices")
    private Set<PhysicianEntity> physicians;

    public static MedicalOffice toDomain(MedicalOfficeEntity medicalOffice) {
        return MedicalOffice.builder()
                .id(medicalOffice.getId())
                .name(medicalOffice.getName())
                .image(medicalOffice.getImage())
                .address(medicalOffice.getAddress())
                .city(medicalOffice.getCity())
                .state(medicalOffice.getState())
                .postalCode(medicalOffice.getPostalCode())
                .country(medicalOffice.getCountry())
                .build();
    }

    public static MedicalOfficeEntity fromDomain(MedicalOffice medicalOffice) {
        return MedicalOfficeEntity.builder()
                .id(medicalOffice.getId())
                .name(medicalOffice.getName())
                .image(medicalOffice.getImage())
                .address(medicalOffice.getAddress())
                .city(medicalOffice.getCity())
                .state(medicalOffice.getState())
                .postalCode(medicalOffice.getPostalCode())
                .country(medicalOffice.getCountry())
                .build();
    }

    public static MedicalOfficeEntity patchEntity(MedicalOffice medicalOffice, MedicalOfficeEntity currentMedicalOffice) {
        return MedicalOfficeEntity.builder()
                .id(medicalOffice.getId())
                .name(medicalOffice.getName() != null ? medicalOffice.getName() : currentMedicalOffice.getName())
                .image(medicalOffice.getImage() != null ? medicalOffice.getImage() : currentMedicalOffice.getImage())
                .address(medicalOffice.getAddress() != null ? medicalOffice.getAddress() : currentMedicalOffice.getAddress())
                .city(medicalOffice.getCity() != null ? medicalOffice.getCity() : currentMedicalOffice.getCity())
                .state(medicalOffice.getState() != null ? medicalOffice.getState() : currentMedicalOffice.getState())
                .postalCode(medicalOffice.getPostalCode() != null ? medicalOffice.getPostalCode() : currentMedicalOffice.getPostalCode())
                .country(medicalOffice.getCountry() != null ? medicalOffice.getCountry() : currentMedicalOffice.getCountry())
                .build();
    }
}

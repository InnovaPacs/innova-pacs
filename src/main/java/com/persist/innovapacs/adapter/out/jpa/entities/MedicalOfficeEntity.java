package com.persist.innovapacs.adapter.out.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany(mappedBy = "medicalOffices")
    private Set<PhysicianEntity> physicians;
}

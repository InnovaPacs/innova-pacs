package com.persist.innovapacs.adapter.out.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class AppointmentEntity {
    @Id()
    String id;
    @Column(name = "appointment_date")
    LocalDate appointmentDate;
    @Column(name = "appointment_time")
    LocalTime appointmentTime;
    @Column(name = "purpose")
    String purpose;
    @Column(name = "status")
    String status;
    @Column(name = "control_number")
    String controlNumber;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientEntity user;

    @ManyToOne
    @JoinColumn(name = "physician_id", referencedColumnName = "id")
    private PhysicianEntity physician;

    @ManyToOne
    @JoinColumn(name = "medical_office_id", referencedColumnName = "id")
    private MedicalOfficeEntity medicalOffice;

    @ManyToOne
    @JoinColumn(name = "study_id", referencedColumnName = "id")
    private StudyEntity study;
}

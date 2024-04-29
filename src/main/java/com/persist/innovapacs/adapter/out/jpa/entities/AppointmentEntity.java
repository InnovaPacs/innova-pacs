package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = true)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "physician_id", referencedColumnName = "id", nullable = true)
    private PhysicianEntity physician;

    @ManyToOne
    @JoinColumn(name = "medical_office_id", referencedColumnName = "id")
    private MedicalOfficeEntity medicalOffice;

    @ManyToOne
    @JoinColumn(name = "study_id", referencedColumnName = "id")
    private StudyEntity study;

    public static Appointment toDomain(AppointmentEntity appointment) {
        return Appointment.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .purpose(appointment.getPurpose())
                .status(appointment.getStatus())
                .controlNumber(appointment.getControlNumber())
                .patient(PatientEntity.toDomain(appointment.getPatient()))
                .physician(PhysicianEntity.toDomain(appointment.getPhysician()))
                .study(StudyEntity.toDomain(appointment.getStudy()))
                .build();
    }

    public static AppointmentEntity fromDomain(Appointment appointment) {
        return AppointmentEntity.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .purpose(appointment.getPurpose())
                .status(appointment.getStatus())
                .controlNumber(appointment.getControlNumber())
                .physician(PhysicianEntity.fromDomain(appointment.getPhysician()))
                .patient(PatientEntity.fromDomain(appointment.getPatient()))
                .medicalOffice(MedicalOfficeEntity.fromDomain(appointment.getMedicalOffice()))
                .study(StudyEntity.fromDomain(appointment.getStudy()))
                .build();
    }

    public static AppointmentEntity patchEntity(Appointment appointment, AppointmentEntity currentAppointment) {
        return AppointmentEntity.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate() != null ? appointment.getAppointmentDate() : currentAppointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime() != null ? appointment.getAppointmentTime() : currentAppointment.getAppointmentTime())
                .purpose(appointment.getPurpose() != null ? appointment.getPurpose() : currentAppointment.getPurpose())
                .status(appointment.getStatus() != null ? appointment.getStatus() : currentAppointment.getStatus())
                .controlNumber(appointment.getControlNumber() != null ? appointment.getControlNumber() : currentAppointment.getControlNumber())
                .build();
    }
}

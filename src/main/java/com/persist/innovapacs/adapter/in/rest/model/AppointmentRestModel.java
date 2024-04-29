package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class AppointmentRestModel {
    String id;
    PatientRestModel patient;
    PhysicianRestModel physician;
    LocalDate appointmentDate;
    LocalTime appointmentTime;
    String purpose;
    String status;
    String controlNumber;
    StudyRestModel study;

    public static AppointmentRestModel fromDomain(Appointment appointment) {
        return AppointmentRestModel.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .purpose(appointment.getPurpose())
                .status(appointment.getStatus())
                .controlNumber(appointment.getControlNumber())
                .study(StudyRestModel.fromDomain(appointment.getStudy()))
                .patient(PatientRestModel.fromDomain(appointment.getPatient()))
                .physician(PhysicianRestModel.fromDomain(appointment.getPhysician()))
                .build();
    }
}

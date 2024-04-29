package com.persist.innovapacs.application.ports.in.appointment;

import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CreateAppointmentCommand {

    Appointment execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        String patientId;
        String physicianId;
        String studyId;
        String medicalOfficeId;
        LocalDate appointmentDate;
        LocalTime appointmentTime;
        String purpose;
        String status;
        String controlNumber;
    }
}

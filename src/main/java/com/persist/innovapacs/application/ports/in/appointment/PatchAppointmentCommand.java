package com.persist.innovapacs.application.ports.in.appointment;

import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

public interface PatchAppointmentCommand {

    Appointment execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        Patient patient;
        Physician physician;
        LocalDate appointmentDate;
        LocalTime appointmentTime;
        String purpose;
        String status;
        String controlNumber;
    }
}

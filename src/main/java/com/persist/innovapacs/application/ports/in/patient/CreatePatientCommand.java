package com.persist.innovapacs.application.ports.in.patient;

import com.persist.innovapacs.application.ports.in.patient.commands.PatientCommand;
import com.persist.innovapacs.domain.Patient;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

public interface CreatePatientCommand {

    Patient execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        String firstName;
        String lastName;
        LocalDate dateOfBirth;
        String gender;
        String documentId;
        String phoneNumber;
        String address;
        String city;
        String state;
        String ssn;
        String postalCode;
        String country;
        String notes;
        String maritalStatus;
        String emergencyContact;
    }
}

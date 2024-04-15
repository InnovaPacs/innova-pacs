package com.persist.innovapacs.application.ports.in.physician;

import com.persist.innovapacs.domain.Physician;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public interface CreatePhysicianCommand {

    Physician execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        String firstName;
        String lastName;
        LocalDate dateOfBirth;
        String gender;
        String specialization;
        String documentId;
        String phoneNumber;
        String address;
        String city;
        String state;
        String postalCode;
        String country;
    }
}

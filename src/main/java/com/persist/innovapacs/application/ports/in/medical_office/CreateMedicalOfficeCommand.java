package com.persist.innovapacs.application.ports.in.medical_office;

import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.domain.Patient;
import lombok.Builder;
import lombok.Getter;

public interface CreateMedicalOfficeCommand {

    MedicalOffice execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        String name;
        String image;
        String address;
        String city;
        String state;
        String postalCode;
        String country;
    }
}

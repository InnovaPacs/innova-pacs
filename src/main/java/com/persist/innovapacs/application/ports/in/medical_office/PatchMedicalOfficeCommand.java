package com.persist.innovapacs.application.ports.in.medical_office;

import com.persist.innovapacs.domain.MedicalOffice;
import lombok.Builder;
import lombok.Getter;

public interface PatchMedicalOfficeCommand {

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

package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.persist.innovapacs.domain.MedicalOffice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class MedicalOfficeRestModel {
    String id;
    String name;
    String image;
    String address;
    String city;
    String state;
    String postalCode;
    String country;

    public static MedicalOfficeRestModel fromDomain(MedicalOffice medicalOffice) {

        if (medicalOffice == null) return null;

        return MedicalOfficeRestModel.builder()
                .id(medicalOffice.getId())
                .name(medicalOffice.getName())
                .image(medicalOffice.getImage())
                .address(medicalOffice.getAddress())
                .city(medicalOffice.getCity())
                .state(medicalOffice.getState())
                .postalCode(medicalOffice.getPostalCode())
                .country(medicalOffice.getCountry())
                .build();
    }

    public static MedicalOffice toDomain(MedicalOfficeRestModel medicalOfficeRestModel) {
        return MedicalOffice.builder()
                .id(medicalOfficeRestModel.getId())
                .name(medicalOfficeRestModel.getName())
                .image(medicalOfficeRestModel.getImage())
                .address(medicalOfficeRestModel.getAddress())
                .city(medicalOfficeRestModel.getCity())
                .state(medicalOfficeRestModel.getState())
                .postalCode(medicalOfficeRestModel.getPostalCode())
                .country(medicalOfficeRestModel.getCountry())
                .build();
    }
}

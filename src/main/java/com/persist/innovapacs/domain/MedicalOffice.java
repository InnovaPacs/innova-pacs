package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalOffice {
    String id;
    String name;
    String image;
    String address;
    String city;
    String state;
    String postalCode;
    String country;
}

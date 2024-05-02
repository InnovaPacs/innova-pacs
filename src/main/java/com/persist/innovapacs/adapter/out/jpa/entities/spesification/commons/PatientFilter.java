package com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientFilter {
    String documentId;
    String medicalOfficeId;
    String firstName;
    String lastName;
    Integer page;
    Integer size;
}

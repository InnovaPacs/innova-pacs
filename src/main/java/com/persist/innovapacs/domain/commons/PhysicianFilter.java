package com.persist.innovapacs.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianFilter {
    String documentId;
    String medicalOfficeId;
    String firstName;
    String lastName;
    Integer page;
    Integer size;
}

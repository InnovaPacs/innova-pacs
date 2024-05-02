package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.persist.innovapacs.domain.Study;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class CreateStudyRestModel {
    String id;
    String patientId;
    String physicianId;
    String modalityId;
    LocalDate studyDate;
    String studyType;
    String studyDescription;
    String studyResults;

    public static CreateStudyRestModel fromDomain(Study study) {

        if (study == null) return null;

        return CreateStudyRestModel.builder()
                .id(study.getId())
                .studyDate(study.getStudyDate())
                .studyType(study.getStudyType())
                .studyDescription(study.getStudyDescription())
                .studyResults(study.getStudyResults())
                .build();
    }
}

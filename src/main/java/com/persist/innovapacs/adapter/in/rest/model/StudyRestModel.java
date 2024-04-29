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
public class StudyRestModel {
    String id;
    PatientRestModel patient;
    PhysicianRestModel physician;
    LocalDate studyDate;
    String modality;
    String studyType;
    String studyDescription;
    String studyResults;

    public static StudyRestModel fromDomain(Study study) {

        if (study == null) return null;

        return StudyRestModel.builder()
                .id(study.getId())
                .patient(PatientRestModel.fromDomain(study.getPatient()))
                .physician(PhysicianRestModel.fromDomain(study.getPhysician()))
                .studyDate(study.getStudyDate())
                .modality(study.getModality())
                .studyType(study.getStudyType())
                .studyDescription(study.getStudyDescription())
                .studyResults(study.getStudyResults())
                .patient(PatientRestModel.fromDomain(study.getPatient()))
                .physician(PhysicianRestModel.fromDomain(study.getPhysician()))
                .build();
    }
}

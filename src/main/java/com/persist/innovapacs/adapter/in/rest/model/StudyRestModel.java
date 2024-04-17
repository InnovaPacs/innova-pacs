package com.persist.innovapacs.adapter.in.rest.model;

import com.persist.innovapacs.domain.Study;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
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
                .build();
    }
}

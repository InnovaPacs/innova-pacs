package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Study {
    String id;
    Patient patient;
    Physician physician;
    LocalDate studyDate;
    String modality;
    String studyType;
    String studyDescription;
    String studyResults;
}

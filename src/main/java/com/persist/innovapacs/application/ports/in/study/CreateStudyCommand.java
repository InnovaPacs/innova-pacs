package com.persist.innovapacs.application.ports.in.study;

import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.Study;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public interface CreateStudyCommand {

    Study execute(Data data);

    @Getter
    @Builder
    class Data {
        String id;
        String patientId;
        String physicianId;
        String modalityId;
        LocalDate studyDate;
        String studyType;
        String studyDescription;
        String studyResults;
    }
}

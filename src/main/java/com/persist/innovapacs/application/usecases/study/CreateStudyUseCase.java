package com.persist.innovapacs.application.usecases.study;

import com.persist.innovapacs.application.ports.in.study.CreateStudyCommand;
import com.persist.innovapacs.application.ports.out.StudyRepository;
import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.Study;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateStudyUseCase implements CreateStudyCommand {
    private final StudyRepository studyRepository;

    @Override
    public Study execute(Data data) {
        return studyRepository.save(Study.builder()
                .id(UUID.randomUUID().toString())
                .patient(Patient.builder().id(data.getPatientId()).build())
                .physician(Physician.builder().id(data.getPhysicianId()).build())
                .studyDate(data.getStudyDate())
                .modality(Modality.builder().id(data.getModalityId()).build())
                .studyType(data.getStudyType())
                .studyDescription(data.getStudyDescription())
                .studyResults(data.getStudyResults())
                .build());
    }
}

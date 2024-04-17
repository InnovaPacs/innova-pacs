package com.persist.innovapacs.application.usecases.study;

import com.persist.innovapacs.application.ports.in.study.CreateStudyCommand;
import com.persist.innovapacs.application.ports.out.StudyRepository;
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
                .patient(data.getPatient())
                .physician(data.getPhysician())
                .studyDate(data.getStudyDate())
                .modality(data.getModality())
                .studyType(data.getStudyType())
                .studyDescription(data.getStudyDescription())
                .studyResults(data.getStudyResults())
                .build());
    }
}

package com.persist.innovapacs.application.usecases.study;

import com.persist.innovapacs.application.ports.in.study.PatchStudyCommand;
import com.persist.innovapacs.application.ports.out.StudyRepository;
import com.persist.innovapacs.domain.Study;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchStudyUseCase implements PatchStudyCommand {
    private final StudyRepository studyRepository;

    @Override
    public Study execute(Data data) {
        return studyRepository.patch(Study.builder()
                .id(data.getId())
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

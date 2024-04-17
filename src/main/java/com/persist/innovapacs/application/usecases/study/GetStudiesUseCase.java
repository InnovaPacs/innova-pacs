package com.persist.innovapacs.application.usecases.study;

import com.persist.innovapacs.application.ports.in.study.GetStudiesQuery;
import com.persist.innovapacs.application.ports.out.StudyRepository;
import com.persist.innovapacs.domain.Study;
import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.commons.StudyFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetStudiesUseCase implements GetStudiesQuery {
    private final StudyRepository studyRepository;

    @Override
    public Page<Study> execute(Data data) {
        return studyRepository.findAll(StudyFilter.builder()
                .page(data.getPage())
                .size(data.getSize())
                .build());
    }
}

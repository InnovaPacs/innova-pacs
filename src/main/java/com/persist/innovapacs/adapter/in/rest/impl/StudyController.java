package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IStudyController;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.adapter.in.rest.model.StudyRestModel;
import com.persist.innovapacs.application.ports.in.study.CreateStudyCommand;
import com.persist.innovapacs.application.ports.in.study.GetStudiesQuery;
import com.persist.innovapacs.application.ports.in.study.PatchStudyCommand;
import com.persist.innovapacs.domain.Study;
import com.persist.innovapacs.domain.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/studies")
public class StudyController implements IStudyController {
    private final GetStudiesQuery getStudyQuery;
    private final CreateStudyCommand createStudyCommand;
    private final PatchStudyCommand patchStudyCommand;

    @Override
    public PageRestModel<StudyRestModel> findAll(Integer size, Integer page) {
        log.info("GET /v1/studies");

        Page<Study> studies = getStudyQuery.execute(GetStudiesQuery.Data.builder()
                .page(page)
                .size(size)
                .build());
        return new PageRestModel<StudyRestModel>().fromDomain(studies, StudyRestModel::fromDomain);
    }

    @Override
    public StudyRestModel create(StudyRestModel studyRestModel) {
        log.info("POST /v1/studies");

        Study study = createStudyCommand.execute(CreateStudyCommand.Data.builder()
                .studyDate(studyRestModel.getStudyDate())
                .modality(studyRestModel.getModality())
                .studyType(studyRestModel.getStudyType())
                .studyDescription(studyRestModel.getStudyDescription())
                .studyResults(studyRestModel.getStudyResults())
                .build());

        return StudyRestModel.fromDomain(study);
    }

    @Override
    public StudyRestModel update(String studyId, StudyRestModel studyRestModel) {
        log.info("PATCH /v1/studies/{}", studyId);

        Study study = patchStudyCommand.execute(PatchStudyCommand.Data.builder()
                .id(studyId)
                .studyDate(studyRestModel.getStudyDate())
                .modality(studyRestModel.getModality())
                .studyType(studyRestModel.getStudyType())
                .studyDescription(studyRestModel.getStudyDescription())
                .studyResults(studyRestModel.getStudyResults())
                .build());

        return StudyRestModel.fromDomain(study);
    }
}

package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Study;
import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.commons.StudyFilter;

public interface StudyRepository {
    Page<Study> findAll(StudyFilter filter);
    Study save(Study study);
    Study patch(Study study);
}

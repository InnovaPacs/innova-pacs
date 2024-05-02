package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.ModalityFilter;
import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.StudyFilter;

public interface ModalityRepository {
    Page<Modality> findAll(ModalityFilter filter);
    Modality save(Modality study);
    Modality patch(Modality study);
    Modality findById(String studyId);
}

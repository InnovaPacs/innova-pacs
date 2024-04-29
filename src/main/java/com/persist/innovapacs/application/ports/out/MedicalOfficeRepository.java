package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.domain.commons.MedicalOfficeFilter;
import com.persist.innovapacs.domain.commons.Page;

public interface MedicalOfficeRepository {
    Page<MedicalOffice> findAll(MedicalOfficeFilter filter);
    MedicalOffice save(MedicalOffice medicalOffice);
    MedicalOffice patch(MedicalOffice medicalOffice);
    MedicalOffice findById(String medicalOfficeId);
}

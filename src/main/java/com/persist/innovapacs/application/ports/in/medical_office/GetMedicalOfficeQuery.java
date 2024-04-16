package com.persist.innovapacs.application.ports.in.medical_office;

import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.Page;
import lombok.Builder;
import lombok.Getter;

public interface GetMedicalOfficeQuery {

    Page<MedicalOffice> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
    }
}

package com.persist.innovapacs.application.ports.in.medical_office;

import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
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

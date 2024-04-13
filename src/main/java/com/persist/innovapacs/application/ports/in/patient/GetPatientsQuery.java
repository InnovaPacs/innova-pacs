package com.persist.innovapacs.application.ports.in.patient;

import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.Patient;
import lombok.Builder;
import lombok.Getter;

public interface GetPatientsQuery {

    Page<Patient> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
        String documentId;
        String firstName;
        String lastName;
        String medicalOfficeId;
    }
}

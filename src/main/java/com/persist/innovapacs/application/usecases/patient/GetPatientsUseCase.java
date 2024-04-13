package com.persist.innovapacs.application.usecases.patient;

import com.persist.innovapacs.application.ports.in.patient.GetPatientsQuery;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.Filter;
import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.commons.PatientFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPatientsUseCase implements GetPatientsQuery {
    private final PatientRepository patientJPAAdapter;

    @Override
    public Page<Patient> execute(Data data) {

        return patientJPAAdapter.findAllPatients(
                PatientFilter.builder()
                .page(data.getPage())
                .size(data.getSize())
                .documentId(data.getDocumentId())
                .medicalOfficeId(data.getMedicalOfficeId())
                .build());
    }
}

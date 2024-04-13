package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IPatientController;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PatientRestModel;
import com.persist.innovapacs.application.ports.in.patient.GetPatientsQuery;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/patients")
public class PatientController implements IPatientController {
    private final GetPatientsQuery getPatientsQuery;

    @Override
    public PageRestModel<PatientRestModel> findAll(Integer size, Integer page, String documentId, String firstName, String lastName) {
        Page<Patient> patients = this.getPatientsQuery.execute(GetPatientsQuery.Data.builder()
                        .page(page)
                        .size(size)
                        .documentId(documentId)
                        .firstName(firstName)
                        .lastName(lastName)
                        .medicalOfficeId("2") //TODO refactor to get medicalOfficeId from jwt
                .build());
        return new PageRestModel<PatientRestModel>().fromDomain(patients, PatientRestModel::fromDomain);
    }

    @Override
    public PatientRestModel create(PatientRestModel patientRestModel) {
        return null;
    }

    @Override
    public PatientRestModel update(PatientRestModel patientRestModel) {
        return null;
    }
}

package com.persist.innovapacs.application.usecases.patient;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.application.ports.in.patient.CreatePatientCommand;
import com.persist.innovapacs.application.ports.in.patient.commands.PatientCommand;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePatientUseCase implements CreatePatientCommand {
    private final PatientRepository patientJPAAdapter;

    @Override
    public Patient execute(Data data) {

        return patientJPAAdapter.save(Patient.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .dateOfBirth(data.getDateOfBirth())
                .gender(data.getGender())
                .documentId(data.getDocumentId())
                .phoneNumber(data.getPhoneNumber())
                .address(data.getAddress())
                .city(data.getCity())
                .state(data.getState())
                .postalCode(data.getPostalCode())
                .country(data.getCountry())
                .notes(data.getNotes())
                .maritalStatus(data.getMaritalStatus())
                .build());
    }
}

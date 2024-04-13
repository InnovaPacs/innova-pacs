package com.persist.innovapacs.application.usecases.patient;

import com.persist.innovapacs.application.ports.in.patient.PatchPatientCommand;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PatchPatientUseCase implements PatchPatientCommand {
    private final PatientRepository patientJPAAdapter;

    @Override
    public Patient execute(Data data) {

        return patientJPAAdapter.patch(Patient.builder()
                .id(data.getId())
                .documentId(data.getDocumentId())
                .emergencyContact(data.getEmergencyContact())
                .country(data.getCountry())
                .city(data.getCity())
                .notes(data.getNotes())
                .state(data.getState())
                .ssn(data.getSsn())
                .dateOfBirth(data.getDateOfBirth())
                .gender(data.getGender())
                .address(data.getAddress())
                .maritalStatus(data.getMaritalStatus())
                .phoneNumber(data.getPhoneNumber())
                .postalCode(data.getPostalCode())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .build());
    }
}

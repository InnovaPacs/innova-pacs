package com.persist.innovapacs.application.usecases.medical_office;

import com.persist.innovapacs.application.ports.in.medical_office.CreateMedicalOfficeCommand;
import com.persist.innovapacs.application.ports.in.patient.CreatePatientCommand;
import com.persist.innovapacs.application.ports.out.MedicalOfficeRepository;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.domain.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateMedicalOfficeUseCase implements CreateMedicalOfficeCommand {
    private final MedicalOfficeRepository medicalOfficeRepository;

    @Override
    public MedicalOffice execute(Data data) {

        return medicalOfficeRepository.save(MedicalOffice.builder()
                .id(UUID.randomUUID().toString())
                .name(data.getName())
                .image(data.getImage())
                .address(data.getAddress())
                .city(data.getCity())
                .state(data.getState())
                .postalCode(data.getPostalCode())
                .country(data.getCountry())
                .build());
    }
}

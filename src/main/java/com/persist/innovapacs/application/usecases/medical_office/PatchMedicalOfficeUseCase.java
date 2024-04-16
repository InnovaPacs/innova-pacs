package com.persist.innovapacs.application.usecases.medical_office;

import com.persist.innovapacs.application.ports.in.medical_office.PatchMedicalOfficeCommand;
import com.persist.innovapacs.application.ports.out.MedicalOfficeRepository;
import com.persist.innovapacs.domain.MedicalOffice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PatchMedicalOfficeUseCase implements PatchMedicalOfficeCommand {
    private final MedicalOfficeRepository medicalOfficeRepository;

    @Override
    public MedicalOffice execute(Data data) {

        return medicalOfficeRepository.patch(MedicalOffice.builder()
                .id(data.getId())
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

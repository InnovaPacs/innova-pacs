package com.persist.innovapacs.application.usecases.physician;

import com.persist.innovapacs.application.ports.in.physician.CreatePhysicianCommand;
import com.persist.innovapacs.application.ports.out.PhysicianRepository;
import com.persist.innovapacs.domain.Physician;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreatePhysicianUseCase implements CreatePhysicianCommand {
    private final PhysicianRepository physicianJPAAdapter;

    @Override
    public Physician execute(CreatePhysicianCommand.Data data) {

        return physicianJPAAdapter.save(Physician.builder()
                .id(UUID.randomUUID().toString())
                .documentId(data.getDocumentId())
                .country(data.getCountry())
                .city(data.getCity())
                .state(data.getState())
                .dateOfBirth(data.getDateOfBirth())
                .gender(data.getGender())
                .address(data.getAddress())
                .phoneNumber(data.getPhoneNumber())
                .postalCode(data.getPostalCode())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .specialization(data.getSpecialization())
                .build());
    }
}

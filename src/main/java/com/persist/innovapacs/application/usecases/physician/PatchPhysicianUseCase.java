package com.persist.innovapacs.application.usecases.physician;

import com.persist.innovapacs.application.ports.in.physician.PatchPhysicianCommand;
import com.persist.innovapacs.application.ports.out.PhysicianRepository;
import com.persist.innovapacs.domain.Physician;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchPhysicianUseCase implements PatchPhysicianCommand {
    private final PhysicianRepository physicianJPAAdapter;

    @Override
    public Physician execute(Data data) {
        return physicianJPAAdapter.patch(Physician.builder()
                .id(data.getId())
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

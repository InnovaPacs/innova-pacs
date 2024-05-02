package com.persist.innovapacs.application.usecases.modality;

import com.persist.innovapacs.application.ports.in.modality.CreateModalityCommand;
import com.persist.innovapacs.application.ports.out.ModalityRepository;
import com.persist.innovapacs.domain.Modality;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateModalityUseCase implements CreateModalityCommand {
    private final ModalityRepository modalityRepository;

    @Override
    public Modality execute(Data data) {
        return modalityRepository.save(Modality.builder()
                .id(UUID.randomUUID().toString())
                .name(data.getName())
                .description(data.getDescription())
                .build());
    }
}

package com.persist.innovapacs.application.usecases.modality;

import com.persist.innovapacs.application.ports.in.modality.PatchModalityCommand;
import com.persist.innovapacs.application.ports.out.ModalityRepository;
import com.persist.innovapacs.domain.Modality;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchModalityUseCase implements PatchModalityCommand {
    private final ModalityRepository modalityRepository;

    @Override
    public Modality execute(Data data) {
        return modalityRepository.patch(Modality.builder()
                .id(data.getId())
                .name(data.getName())
                .description(data.getDescription())
                .build());
    }
}

package com.persist.innovapacs.application.ports.in.modality;

import com.persist.innovapacs.domain.Modality;
import lombok.Builder;
import lombok.Getter;
public interface CreateModalityCommand {

    Modality execute(Data data);

    @Getter
    @Builder
    class Data {
        String name;
        String description;
    }
}

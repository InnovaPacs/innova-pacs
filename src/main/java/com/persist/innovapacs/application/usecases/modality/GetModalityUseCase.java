package com.persist.innovapacs.application.usecases.modality;

import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.ModalityFilter;
import com.persist.innovapacs.application.ports.in.modality.GetModalitiesQuery;
import com.persist.innovapacs.application.ports.out.ModalityRepository;
import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetModalityUseCase implements GetModalitiesQuery {
    private final ModalityRepository modalityRepository;

    @Override
    public Page<Modality> execute(Data data) {
        return modalityRepository.findAll(ModalityFilter.builder()
                .page(data.getPage())
                .size(data.getSize())
                .name(data.getName())
                .build());
    }
}

package com.persist.innovapacs.application.ports.in.modality;

import com.persist.innovapacs.domain.Modality;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.Builder;
import lombok.Getter;

public interface GetModalitiesQuery {

    Page<Modality> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
        String name;
    }
}

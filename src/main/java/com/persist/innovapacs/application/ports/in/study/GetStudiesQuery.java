package com.persist.innovapacs.application.ports.in.study;

import com.persist.innovapacs.domain.Study;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.Builder;
import lombok.Getter;

public interface GetStudiesQuery {

    Page<Study> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
    }
}

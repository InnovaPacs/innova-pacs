package com.persist.innovapacs.application.ports.in.physician;

import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.commons.Page;
import lombok.Builder;
import lombok.Getter;

public interface GetPhysiciansQuery {

    Page<Physician> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
        String documentId;
        String firstName;
        String lastName;
    }
}

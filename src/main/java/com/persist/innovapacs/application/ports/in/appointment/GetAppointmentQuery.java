package com.persist.innovapacs.application.ports.in.appointment;

import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.Builder;
import lombok.Getter;

public interface GetAppointmentQuery {

    Page<Appointment> execute(Data data);

    @Getter
    @Builder
    class Data {
        Integer size;
        Integer page;
    }
}

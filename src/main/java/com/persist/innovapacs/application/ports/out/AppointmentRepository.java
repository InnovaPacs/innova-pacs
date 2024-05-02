package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.AppointmentFilter;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;

public interface AppointmentRepository {
    Page<Appointment> findAllPatients(AppointmentFilter filter);
    Appointment save(Appointment appointment);
    Appointment patch(Appointment appointment);
}

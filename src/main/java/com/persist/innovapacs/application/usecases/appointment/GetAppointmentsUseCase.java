package com.persist.innovapacs.application.usecases.appointment;

import com.persist.innovapacs.application.ports.in.appointment.GetAppointmentQuery;
import com.persist.innovapacs.application.ports.out.AppointmentRepository;
import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.commons.AppointmentFilter;
import com.persist.innovapacs.domain.commons.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAppointmentsUseCase implements GetAppointmentQuery {
    private final AppointmentRepository appointmentJPAAdapter;

    @Override
    public Page<Appointment> execute(Data data) {

        return appointmentJPAAdapter.findAllPatients(
                AppointmentFilter.builder()
                        .page(data.getPage())
                        .size(data.getSize())
                        .build());
    }
}

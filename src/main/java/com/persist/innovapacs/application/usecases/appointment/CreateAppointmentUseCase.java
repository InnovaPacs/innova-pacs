package com.persist.innovapacs.application.usecases.appointment;

import com.persist.innovapacs.application.ports.in.appointment.CreateAppointmentCommand;
import com.persist.innovapacs.application.ports.out.AppointmentRepository;
import com.persist.innovapacs.domain.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateAppointmentUseCase implements CreateAppointmentCommand {
    private final AppointmentRepository appointmentJPAAdapter;

    @Override
    public Appointment execute(Data data) {
        return appointmentJPAAdapter.save(Appointment.builder()
                .id(UUID.randomUUID().toString())
                .controlNumber(data.getControlNumber())
                        .status(data.getStatus())
                        .appointmentTime(data.getAppointmentTime())
                        .appointmentDate(data.getAppointmentDate())
                        .purpose(data.getPurpose())
                .build());
    }
}

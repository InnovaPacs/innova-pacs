package com.persist.innovapacs.application.usecases.appointment;

import com.persist.innovapacs.application.ports.in.appointment.PatchAppointmentCommand;
import com.persist.innovapacs.application.ports.out.AppointmentRepository;
import com.persist.innovapacs.domain.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchAppointmentUseCase implements PatchAppointmentCommand {
    private final AppointmentRepository appointmentJPAAdapter;

    @Override
    public Appointment execute(Data data) {
        return appointmentJPAAdapter.patch(Appointment.builder()
                .id(data.getId())
                .controlNumber(data.getControlNumber())
                .status(data.getStatus())
                .appointmentTime(data.getAppointmentTime())
                .appointmentDate(data.getAppointmentDate())
                .purpose(data.getPurpose())
                .build());
    }
}

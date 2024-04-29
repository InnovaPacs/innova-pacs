package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IAppointmentController;
import com.persist.innovapacs.adapter.in.rest.model.AppointmentRestModel;
import com.persist.innovapacs.adapter.in.rest.model.CreateAppointmentRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.application.ports.in.appointment.CreateAppointmentCommand;
import com.persist.innovapacs.application.ports.in.appointment.GetAppointmentQuery;
import com.persist.innovapacs.application.ports.in.appointment.PatchAppointmentCommand;
import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/appointments")
public class AppointmentController implements IAppointmentController {
    private final GetAppointmentQuery getAppointmentQuery;
    private final CreateAppointmentCommand createAppointmentCommand;
    private final PatchAppointmentCommand patchAppointmentCommand;

    @Override
    public PageRestModel<AppointmentRestModel> findAll(Integer size, Integer page) {
        log.info("GET /v1/appointments");

        Page<Appointment> appointments = getAppointmentQuery.execute(GetAppointmentQuery.Data.builder()
                        .page(page)
                        .size(size)
                .build());
        return new PageRestModel<AppointmentRestModel>().fromDomain(appointments, AppointmentRestModel::fromDomain);
    }

    @Override
    public AppointmentRestModel create(CreateAppointmentRestModel appointmentRestModel) {
        log.info("POST /v1/appointments");

        Appointment appointment = createAppointmentCommand.execute(CreateAppointmentCommand.Data.builder()
                        .appointmentDate(appointmentRestModel.getAppointmentDate())
                        .appointmentTime(appointmentRestModel.getAppointmentTime())
                        .controlNumber(appointmentRestModel.getControlNumber())//TODO create statue
                        .status(appointmentRestModel.getStatus())//TODO create statue
                        .physicianId(appointmentRestModel.getPhysicianId())
                        .patientId(appointmentRestModel.getPatientId())
                        .studyId(appointmentRestModel.getStudyId())
                        .medicalOfficeId(appointmentRestModel.getMedicalOfficeId())
                        .purpose(appointmentRestModel.getPurpose())
                .build());

        return AppointmentRestModel.fromDomain(appointment);
    }

    @Override
    public AppointmentRestModel update(String patientId, AppointmentRestModel appointmentRestModel) {
        log.info("PATCH /v1/appointments/{}", patientId);

        Appointment appointment = patchAppointmentCommand.execute(PatchAppointmentCommand.Data.builder()
                .id(patientId)
                .appointmentDate(appointmentRestModel.getAppointmentDate())
                .appointmentTime(appointmentRestModel.getAppointmentTime())
                .controlNumber(appointmentRestModel.getControlNumber())
                .status(appointmentRestModel.getStatus())
                .purpose(appointmentRestModel.getPurpose())
                .build());

        return AppointmentRestModel.fromDomain(appointment);
    }
}

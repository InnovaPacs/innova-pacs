package com.persist.innovapacs.adapter.in.rest;

import com.persist.innovapacs.adapter.in.rest.model.AppointmentRestModel;
import com.persist.innovapacs.adapter.in.rest.model.CreateAppointmentRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAppointmentController {
    @GetMapping()
    PageRestModel<AppointmentRestModel> findAll(@RequestParam(name = "size") Integer size, @RequestParam(name = "page") Integer page);
    @PostMapping
    AppointmentRestModel create(@RequestBody CreateAppointmentRestModel appointmentRestModel);
    @PatchMapping("/{patientId}")
    AppointmentRestModel update(@PathVariable() String patientId, @RequestBody AppointmentRestModel appointmentRestModel);
}

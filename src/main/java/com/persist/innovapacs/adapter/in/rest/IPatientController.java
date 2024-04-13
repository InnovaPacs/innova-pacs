package com.persist.innovapacs.adapter.in.rest;

import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PatientRestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IPatientController {
    @GetMapping()
    PageRestModel<PatientRestModel> findAll(@RequestParam(name = "size") Integer size, @RequestParam(name = "page") Integer page,
                                            @RequestParam(name = "documentId", required = false) String documentId,
                                            @RequestParam(name = "firstName", required = false) String firstName,
                                            @RequestParam(name = "lastName", required = false) String lastName);
    @PostMapping
    PatientRestModel create(@RequestBody PatientRestModel patientRestModel);
    @PatchMapping("/{patientId}")
    PatientRestModel update(@PathVariable() String patientId, @RequestBody PatientRestModel patientRestModel);
}

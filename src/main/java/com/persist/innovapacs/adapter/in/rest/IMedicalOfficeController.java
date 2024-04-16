package com.persist.innovapacs.adapter.in.rest;

import com.persist.innovapacs.adapter.in.rest.model.MedicalOfficeRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMedicalOfficeController {
    @GetMapping()
    PageRestModel<MedicalOfficeRestModel> findAll(@RequestParam(name = "size") Integer size, @RequestParam(name = "page") Integer page);
    @PostMapping
    MedicalOfficeRestModel create(@RequestBody MedicalOfficeRestModel medicalOfficeRestModel);
    @PatchMapping("/{medicalOfficeId}")
    MedicalOfficeRestModel update(@PathVariable() String medicalOfficeId, @RequestBody MedicalOfficeRestModel medicalOfficeRestModel);
}

package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IMedicalOfficeController;
import com.persist.innovapacs.adapter.in.rest.model.MedicalOfficeRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.application.ports.in.medical_office.CreateMedicalOfficeCommand;
import com.persist.innovapacs.application.ports.in.medical_office.GetMedicalOfficeQuery;
import com.persist.innovapacs.application.ports.in.medical_office.PatchMedicalOfficeCommand;
import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/medical-office")
public class MedicalOfficeController implements IMedicalOfficeController {
    private final GetMedicalOfficeQuery medicalOfficeQuery;
    private final CreateMedicalOfficeCommand medicalOfficeCommand;
    private final PatchMedicalOfficeCommand patchMedicalOfficeCommand;


    @Override
    public PageRestModel<MedicalOfficeRestModel> findAll(Integer size, Integer page) {

        Page<MedicalOffice> medicalOfficePage = medicalOfficeQuery.execute(GetMedicalOfficeQuery.Data.builder()
                .page(page)
                .size(size)
                .build());
        return new PageRestModel<MedicalOfficeRestModel>().fromDomain(medicalOfficePage, MedicalOfficeRestModel::fromDomain);
    }

    @Override
    public MedicalOfficeRestModel create(MedicalOfficeRestModel medicalOfficeRestModel) {

        MedicalOffice medicalOffice = medicalOfficeCommand.execute(CreateMedicalOfficeCommand.Data.builder()
                .name(medicalOfficeRestModel.getName())
                .image(medicalOfficeRestModel.getImage())
                .address(medicalOfficeRestModel.getAddress())
                .city(medicalOfficeRestModel.getCity())
                .state(medicalOfficeRestModel.getState())
                .postalCode(medicalOfficeRestModel.getPostalCode())
                .country(medicalOfficeRestModel.getCountry())
                .build());

        return MedicalOfficeRestModel.fromDomain(medicalOffice);
    }

    @Override
    public MedicalOfficeRestModel update(String medicalOfficeId, MedicalOfficeRestModel medicalOfficeRestModel) {

        MedicalOffice medicalOffice = patchMedicalOfficeCommand.execute(PatchMedicalOfficeCommand.Data.builder()
                .id(medicalOfficeId)
                .name(medicalOfficeRestModel.getName())
                .image(medicalOfficeRestModel.getImage())
                .address(medicalOfficeRestModel.getAddress())
                .city(medicalOfficeRestModel.getCity())
                .state(medicalOfficeRestModel.getState())
                .postalCode(medicalOfficeRestModel.getPostalCode())
                .country(medicalOfficeRestModel.getCountry())
                .build());

        return MedicalOfficeRestModel.fromDomain(medicalOffice);
    }
}

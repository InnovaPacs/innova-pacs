package com.persist.innovapacs.adapter.in.rest.impl;

import com.persist.innovapacs.adapter.in.rest.IPhysicianController;
import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.adapter.in.rest.model.PhysicianRestModel;
import com.persist.innovapacs.application.ports.in.physician.CreatePhysicianCommand;
import com.persist.innovapacs.application.ports.in.physician.GetPhysiciansQuery;
import com.persist.innovapacs.application.ports.in.physician.PatchPhysicianCommand;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.commons.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping(path = "/v1/physicians")
public class PhysicianController implements IPhysicianController {
    private final GetPhysiciansQuery getPhysicianQuery;
    private final CreatePhysicianCommand createPhysicianCommand;
    private final PatchPhysicianCommand patchPhysicianCommand;

    @Override
    public PageRestModel<PhysicianRestModel> findAll(Integer size, Integer page, String documentId, String firstName, String lastName) {
        log.info("GET /v1/physicians");

        Page<Physician> physicians = this.getPhysicianQuery.execute(GetPhysiciansQuery.Data.builder()
                .page(page)
                .size(size)
                .documentId(documentId)
                .firstName(firstName)
                .lastName(lastName)
                .build());
        return new PageRestModel<PhysicianRestModel>().fromDomain(physicians, PhysicianRestModel::fromDomain);
    }

    @Override
    public PhysicianRestModel create(PhysicianRestModel physicianRestModel) {
        log.info("POST /v1/physicians");

        Physician physician = createPhysicianCommand.execute(CreatePhysicianCommand.Data.builder()
                .documentId(physicianRestModel.getDocumentId())
                .country(physicianRestModel.getCountry())
                .city(physicianRestModel.getCity())
                .state(physicianRestModel.getState())
                .dateOfBirth(physicianRestModel.getDateOfBirth())
                .gender(physicianRestModel.getGender())
                .address(physicianRestModel.getAddress())
                .phoneNumber(physicianRestModel.getPhoneNumber())
                .postalCode(physicianRestModel.getPostalCode())
                .firstName(physicianRestModel.getFirstName())
                .lastName(physicianRestModel.getLastName())
                .build());

        return PhysicianRestModel.fromDomain(physician);
    }

    @Override
    public PhysicianRestModel update(String physicianId, PhysicianRestModel physicianRestModel) {
        log.info("PATCH /v1/physicians/{}", physicianId);

        Physician physician = patchPhysicianCommand.execute(PatchPhysicianCommand.Data.builder()
                .id(physicianId)
                .documentId(physicianRestModel.getDocumentId())
                .country(physicianRestModel.getCountry())
                .city(physicianRestModel.getCity())
                .state(physicianRestModel.getState())
                .dateOfBirth(physicianRestModel.getDateOfBirth())
                .gender(physicianRestModel.getGender())
                .address(physicianRestModel.getAddress())
                .phoneNumber(physicianRestModel.getPhoneNumber())
                .postalCode(physicianRestModel.getPostalCode())
                .firstName(physicianRestModel.getFirstName())
                .lastName(physicianRestModel.getLastName())
                .specialization(physicianRestModel.getSpecialization())
                .build());

        return PhysicianRestModel.fromDomain(physician);
    }
}

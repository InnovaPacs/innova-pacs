package com.persist.innovapacs.application.usecases.physician;

import com.persist.innovapacs.application.ports.in.physician.GetPhysiciansQuery;
import com.persist.innovapacs.application.ports.out.PhysicianRepository;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.PhysicianFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetPhysiciansUseCase implements GetPhysiciansQuery {
    private final PhysicianRepository physicianRepository;

    @Override
    public Page<Physician> execute(GetPhysiciansQuery.Data data) {

        return physicianRepository.findAllPatients(
                PhysicianFilter.builder()
                        .page(data.getPage())
                        .size(data.getSize())
                        .documentId(data.getDocumentId())
                        .build());
    }
}

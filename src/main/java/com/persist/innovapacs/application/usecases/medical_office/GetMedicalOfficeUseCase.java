package com.persist.innovapacs.application.usecases.medical_office;

import com.persist.innovapacs.application.ports.in.medical_office.GetMedicalOfficeQuery;
import com.persist.innovapacs.application.ports.out.MedicalOfficeRepository;
import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.MedicalOfficeFilter;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetMedicalOfficeUseCase implements GetMedicalOfficeQuery {
    private final MedicalOfficeRepository medicalOfficeRepository;

    @Override
    public Page<MedicalOffice> execute(Data data) {

        return medicalOfficeRepository.findAll(
                MedicalOfficeFilter.builder()
                .page(data.getPage())
                .size(data.getSize())
                .build());
    }
}

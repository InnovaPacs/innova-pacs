package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.PhysicianFilter;

public interface PhysicianRepository {
    Page<Physician> findAllPatients(PhysicianFilter filter);
    Physician save(Physician patient);
    Physician patch(Physician patient);
    Physician findById(String patientId);
}

package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.commons.PhysicianFilter;

import java.util.Optional;

public interface PhysicianRepository {
    Page<Physician> findAllPatients(PhysicianFilter filter);
    Physician save(Physician patient);
    Physician patch(Physician patient);
}

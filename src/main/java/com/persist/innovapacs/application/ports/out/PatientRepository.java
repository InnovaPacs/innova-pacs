package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.PatientFilter;

public interface PatientRepository {
    Page<Patient> findAllPatients(PatientFilter filter);
    Patient save(Patient patient);
    Patient patch(Patient patient);
    Patient findById(String patientId);
}

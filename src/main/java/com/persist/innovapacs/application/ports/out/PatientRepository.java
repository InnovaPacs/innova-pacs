package com.persist.innovapacs.application.ports.out;

import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.Page;
import com.persist.innovapacs.domain.commons.PatientFilter;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    Page<Patient> findAllPatients(PatientFilter filter);
    Patient save(Patient patient);
    Patient patch(Patient patient);
}

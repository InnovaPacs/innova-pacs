package com.persist.innovapacs.application.ports.in.patient;

import com.persist.innovapacs.application.ports.in.patient.commands.PatientCommand;
import com.persist.innovapacs.domain.Patient;

public interface PatchPatientCommand {
    Patient execute(PatientCommand patientCommand);
}

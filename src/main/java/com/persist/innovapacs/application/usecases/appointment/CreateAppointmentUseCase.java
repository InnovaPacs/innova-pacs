package com.persist.innovapacs.application.usecases.appointment;

import com.persist.innovapacs.application.ports.in.appointment.CreateAppointmentCommand;
import com.persist.innovapacs.application.ports.out.AppointmentRepository;
import com.persist.innovapacs.application.ports.out.MedicalOfficeRepository;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.application.ports.out.PhysicianRepository;
import com.persist.innovapacs.application.ports.out.StudyRepository;
import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.Study;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateAppointmentUseCase implements CreateAppointmentCommand {
    private final AppointmentRepository appointmentJPAAdapter;
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;
    private final StudyRepository studyRepository;
    private final MedicalOfficeRepository medicalOfficeRepository;

    @Override
    public Appointment execute(Data data) {
        Physician physician = physicianRepository.findById(data.getPhysicianId());
        Patient patient = patientRepository.findById(data.getPatientId());
        Study study = studyRepository.findById(data.getStudyId());
        MedicalOffice medicalOffice = medicalOfficeRepository.findById(data.getMedicalOfficeId());

        return appointmentJPAAdapter.save(Appointment.builder()
                .id(UUID.randomUUID().toString())
                .controlNumber(data.getControlNumber())
                        .status(data.getStatus())
                        .appointmentTime(data.getAppointmentTime())
                        .appointmentDate(data.getAppointmentDate())
                        .purpose(data.getPurpose())
                        .physician(physician)
                        .patient(patient)
                        .study(study)
                        .medicalOffice(medicalOffice)
                .build());
    }
}

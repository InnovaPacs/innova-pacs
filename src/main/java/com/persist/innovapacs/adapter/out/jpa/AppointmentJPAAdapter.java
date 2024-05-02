package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.AppointmentEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.AppointmentSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.AppointmentJPARepository;
import com.persist.innovapacs.application.ports.out.AppointmentRepository;
import com.persist.innovapacs.domain.Appointment;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.AppointmentFilter;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.domain.exception.BusinessException;
import com.persist.innovapacs.domain.exception.EntityConflictException;
import com.persist.innovapacs.domain.exception.EntityNotFoundException;
import com.persist.innovapacs.domain.exception.RepositoryConflictException;
import com.persist.innovapacs.domain.exception.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class AppointmentJPAAdapter implements AppointmentRepository {
    private final AppointmentJPARepository appointmentJPARepository;

    @Override
    public Page<Appointment> findAllPatients(AppointmentFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<AppointmentEntity> spec = AppointmentSpecifications.getQuery(filter);
        org.springframework.data.domain.Page<AppointmentEntity> appointments = appointmentJPARepository.findAll(spec, pageable);

        return Page.<Appointment>builder()
                .size(appointments.getSize())
                .totalPages(appointments.getTotalPages())
                .number(appointments.getNumber())
                .totalElements(appointments.getTotalElements())
                .content(appointments.getContent().stream().map(AppointmentEntity::toDomain).toList())
                .build();
    }

    @Override
    public Appointment save(Appointment appointment) {
        try {

            AppointmentEntity appointmentEntity = AppointmentEntity.fromDomain(appointment);
            return AppointmentEntity.toDomain(appointmentJPARepository.save(appointmentEntity));

        } catch (DataIntegrityViolationException ex) {
            logError("Error saving patient", ex);
            throw new EntityConflictException(ErrorCode.ERROR_SAVING_ENTITY);
        } catch (DataAccessException ex) {
            logError("Unexpected error saving patient", ex);
            throw new RepositoryConflictException(ErrorCode.REPOSITORY_CONFLICT);
        } catch (Exception ex) {
            logError("Unexpected error in saving patient", ex);
            throw new BusinessException(ErrorCode.UNEXPECTED_ERROR);
        }
    }

    @Override
    public Appointment patch(Appointment appointment) {
        try {

            Optional<AppointmentEntity> currentAppointment = appointmentJPARepository.findById(appointment.getId());
            if (currentAppointment.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }

            AppointmentEntity appointmentEntity = AppointmentEntity.patchEntity(appointment, currentAppointment.get());
            return AppointmentEntity.toDomain(appointmentJPARepository.save(appointmentEntity));

        } catch (DataIntegrityViolationException ex) {
            logError("Error patching patient", ex);
            throw new EntityConflictException(ErrorCode.ERROR_SAVING_ENTITY);
        } catch (DataAccessException ex) {
            logError("Unexpected error patching patient", ex);
            throw new RepositoryConflictException(ErrorCode.REPOSITORY_CONFLICT);
        } catch (Exception ex) {
            logError("Unexpected error in patching patient", ex);
            throw new BusinessException(ErrorCode.UNEXPECTED_ERROR);
        }
    }

    private void logError(String message, Throwable ex) {
        log.error(message, ex);
    }
}

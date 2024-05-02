package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.PatientSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.PatientJPARepository;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.PatientFilter;
import com.persist.innovapacs.domain.exception.BusinessException;
import com.persist.innovapacs.domain.exception.EntityConflictException;
import com.persist.innovapacs.domain.exception.EntityNotFoundException;
import com.persist.innovapacs.domain.exception.RepositoryConflictException;
import com.persist.innovapacs.domain.exception.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
@Component
@AllArgsConstructor
public class PatientJPAAdapter implements PatientRepository {
    private final PatientJPARepository patientJPARepository;

    @Override
    public com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page<Patient> findAllPatients(PatientFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<PatientEntity> spec = PatientSpecifications.getQuery(filter);
        Page<PatientEntity> patients = patientJPARepository.findAll(spec, pageable);

        return com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page.<Patient>builder()
                .size(patients.getSize())
                .totalPages(patients.getTotalPages())
                .number(patients.getNumber())
                .totalElements(patients.getTotalElements())
                .content(patients.getContent().stream().map(PatientEntity::toDomain).toList())
                .build();
    }

    @Override
    public Patient save(Patient patient) {
        try {
            PatientEntity patientEntity = PatientEntity.fromDomain(patient);
            return PatientEntity.toDomain(patientJPARepository.save(patientEntity));
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
    public Patient patch(Patient patient) {
        try {
            Optional<PatientEntity> currentPatient = patientJPARepository.findById(patient.getId());
            if (currentPatient.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }
            PatientEntity patientEntity = PatientEntity.patchEntity(patient, currentPatient.get());
            return PatientEntity.toDomain(patientJPARepository.save(patientEntity));
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

    @Override
    public Patient findById(String patientId) {
        Optional<PatientEntity> patient = handleExceptions(() -> patientJPARepository.findById(patientId));

        if(patient.isEmpty()) {
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        }

        return PatientEntity.toDomain(patient.get());
    }

    private void logError(String message, Throwable ex) {
        log.error(message, ex);
    }

    private <T> T handleExceptions(Supplier<T> supplier) {
        try {
            return supplier.get();
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
}

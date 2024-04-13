package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.PatientSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.PatientJPARepository;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.PatientFilter;
import com.persist.innovapacs.domain.exception.BusinessException;
import com.persist.innovapacs.domain.exception.EntityConflictException;
import com.persist.innovapacs.domain.exception.EntityNotFoundException;
import com.persist.innovapacs.domain.exception.RepositoryConflictException;
import com.persist.innovapacs.domain.exception.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class PatientJPAAdapter implements PatientRepository {
    private final PatientJPARepository patientJPARepository;

    @Override
    public com.persist.innovapacs.domain.commons.Page<Patient> findAllPatients(PatientFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());

        Specification<PatientEntity> spec = PatientSpecifications.getQuery(filter);

        Page<PatientEntity> patients = patientJPARepository.findAll(spec, pageable);

        return com.persist.innovapacs.domain.commons.Page.<Patient>builder()
                .size(patients.getSize())
                .totalPages(patients.getTotalPages())
                .number(patients.getNumber())
                .totalElements(patients.getTotalElements())
                .content(patients.getContent().stream().map(PatientEntity::toDomain).toList())
                .build();
    }

    @Override
    public Optional<Patient> findByDocumentId(String documentId) {
        return Optional.empty();
    }

    @Override
    public Patient save(Patient patient) {
        try {

            PatientEntity patientEntity = PatientEntity.fromDomain(patient);
            return PatientEntity.toDomain(patientJPARepository.save(patientEntity));

        }catch (EmptyResultDataAccessException ex) {
            log.error("Error finding Integration", ex);
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        } catch (DataIntegrityViolationException ex) {
            log.error("Error saving Integration", ex);
            throw new EntityConflictException(ErrorCode.ERROR_SAVING_ENTITY);
        } catch (DataAccessException ex) {
            log.error("Unexpected error saving Integration", ex);
            throw new RepositoryConflictException(ErrorCode.REPOSITORY_CONFLICT);
        } catch (Exception ex) {
            log.error("Unexpected error in domain: Integration", ex);
            throw new BusinessException(ErrorCode.UNEXPECTED_ERROR);
        }
    }

    @Override
    public Patient patch(Patient patient) {
        try {

            Optional<PatientEntity> currentPatient = patientJPARepository.findById(patient.getId());

            if(currentPatient.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }

            PatientEntity patientEntity = PatientEntity.patchEntity(patient, currentPatient.get());
            return PatientEntity.toDomain(patientJPARepository.save(patientEntity));

        }catch (EmptyResultDataAccessException ex) {
            log.error("Error finding Integration", ex);
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        } catch (DataIntegrityViolationException ex) {
            log.error("Error saving Integration", ex);
            throw new EntityConflictException(ErrorCode.ERROR_SAVING_ENTITY);
        } catch (DataAccessException ex) {
            log.error("Unexpected error saving Integration", ex);
            throw new RepositoryConflictException(ErrorCode.REPOSITORY_CONFLICT);
        } catch (Exception ex) {
            log.error("Unexpected error in domain: Integration", ex);
            throw new BusinessException(ErrorCode.UNEXPECTED_ERROR);
        }
    }
}

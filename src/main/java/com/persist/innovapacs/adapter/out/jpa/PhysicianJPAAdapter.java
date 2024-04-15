package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.PhysicianEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.PhysicianSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.PhysicianJPARepository;
import com.persist.innovapacs.application.ports.out.PhysicianRepository;
import com.persist.innovapacs.domain.Physician;
import com.persist.innovapacs.domain.commons.PhysicianFilter;
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

@Slf4j
@Component
@AllArgsConstructor
public class PhysicianJPAAdapter implements PhysicianRepository {
    private final PhysicianJPARepository physicianJPARepository;

    @Override
    public com.persist.innovapacs.domain.commons.Page<Physician> findAllPatients(PhysicianFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<PhysicianEntity> spec = PhysicianSpecifications.getQuery(filter);
        Page<PhysicianEntity> physicians = physicianJPARepository.findAll(spec, pageable);

        return com.persist.innovapacs.domain.commons.Page.<Physician>builder()
                .size(physicians.getSize())
                .totalPages(physicians.getTotalPages())
                .number(physicians.getNumber())
                .totalElements(physicians.getTotalElements())
                .content(physicians.getContent().stream().map(PhysicianEntity::toDomain).toList())
                .build();
    }

    @Override
    public Optional<Physician> findByDocumentId(String documentId) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public Physician save(Physician physician) {
        try {

            PhysicianEntity physicianEntity = PhysicianEntity.fromDomain(physician);
            return PhysicianEntity.toDomain(physicianJPARepository.save(physicianEntity));

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
    public Physician patch(Physician physician) {
        try {

            Optional<PhysicianEntity> currentPhysician = physicianJPARepository.findById(physician.getId());
            if (currentPhysician.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }

            PhysicianEntity physicianEntity = PhysicianEntity.patchEntity(physician, currentPhysician.get());
            return PhysicianEntity.toDomain(physicianJPARepository.save(physicianEntity));

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
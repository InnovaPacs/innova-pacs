package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.MedicalOfficeEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.MedicalOfficeSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.MedicalOfficeJPARepository;
import com.persist.innovapacs.application.ports.out.MedicalOfficeRepository;
import com.persist.innovapacs.domain.MedicalOffice;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.MedicalOfficeFilter;
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
import java.util.function.Supplier;

@Slf4j
@Component
@AllArgsConstructor
public class MedicalOfficeJPAAdapter implements MedicalOfficeRepository {
    private final MedicalOfficeJPARepository medicalOfficeJPARepository;

    @Override
    public Page<MedicalOffice> findAll(MedicalOfficeFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<MedicalOfficeEntity> spec = MedicalOfficeSpecifications.getQuery(filter);
        org.springframework.data.domain.Page<MedicalOfficeEntity> medicalOffices = medicalOfficeJPARepository.findAll(spec, pageable);

        return Page.<MedicalOffice>builder()
                .size(medicalOffices.getSize())
                .totalPages(medicalOffices.getTotalPages())
                .number(medicalOffices.getNumber())
                .totalElements(medicalOffices.getTotalElements())
                .content(medicalOffices.getContent().stream().map(MedicalOfficeEntity::toDomain).toList())
                .build();
    }

    @Override
    public MedicalOffice save(MedicalOffice medicalOffice) {
        try {

            MedicalOfficeEntity medicalOfficeEntity = MedicalOfficeEntity.fromDomain(medicalOffice);
            return MedicalOfficeEntity.toDomain(medicalOfficeJPARepository.save(medicalOfficeEntity));

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
    public MedicalOffice patch(MedicalOffice medicalOffice) {
        try {

            Optional<MedicalOfficeEntity> currentMedicalOffice = medicalOfficeJPARepository.findById(medicalOffice.getId());
            if (currentMedicalOffice.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }

            MedicalOfficeEntity medicalOfficeEntity = MedicalOfficeEntity.patchEntity(medicalOffice, currentMedicalOffice.get());
            return MedicalOfficeEntity.toDomain(medicalOfficeJPARepository.save(medicalOfficeEntity));

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
    public MedicalOffice findById(String medicalOfficeId) {
        Optional<MedicalOfficeEntity> medicalOffice = handleExceptions(() -> medicalOfficeJPARepository.findById(medicalOfficeId));

        if(medicalOffice.isEmpty()) {
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        }

        return MedicalOfficeEntity.toDomain(medicalOffice.get());
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

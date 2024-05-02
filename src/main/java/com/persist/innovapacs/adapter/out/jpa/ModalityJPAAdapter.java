package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.ModalityEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.ModalitySpecifications;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.ModalityFilter;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page;
import com.persist.innovapacs.adapter.out.jpa.repositories.ModalityJPARepository;
import com.persist.innovapacs.application.ports.out.ModalityRepository;
import com.persist.innovapacs.domain.Modality;
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
public class ModalityJPAAdapter implements ModalityRepository {
    private final ModalityJPARepository modalityJPARepository;

    @Override
    public Page<Modality> findAll(ModalityFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<ModalityEntity> spec = ModalitySpecifications.getQuery(filter);
        org.springframework.data.domain.Page<ModalityEntity> modalities = handleExceptions(() -> modalityJPARepository.findAll(spec, pageable));

        return com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.Page.<Modality>builder()
                .size(modalities.getSize())
                .totalPages(modalities.getTotalPages())
                .number(modalities.getNumber())
                .totalElements(modalities.getTotalElements())
                .content(modalities.getContent().stream().map(ModalityEntity::toDomain).toList())
                .build();
    }

    @Override
    public Modality save(Modality modality) {
        ModalityEntity modalityEntity = handleExceptions(() -> modalityJPARepository.save(ModalityEntity.fromDomain(modality)));
        return ModalityEntity.toDomain(modalityJPARepository.save(modalityEntity));
    }

    @Override
    public Modality patch(Modality modality) {
        Optional<ModalityEntity> currentModality = handleExceptions(() -> modalityJPARepository.findById(modality.getId()));

        if (currentModality.isEmpty()) {
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        }

        ModalityEntity modalityEntity = ModalityEntity.patchEntity(modality, currentModality.get());
        return ModalityEntity.toDomain(handleExceptions(() -> modalityJPARepository.save(modalityEntity)));
    }

    @Override
    public Modality findById(String modalityId) {
        Optional<ModalityEntity> modality = handleExceptions(() -> modalityJPARepository.findById(modalityId));

        if(modality.isEmpty()) {
            throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
        }

        return ModalityEntity.toDomain(modality.get());
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

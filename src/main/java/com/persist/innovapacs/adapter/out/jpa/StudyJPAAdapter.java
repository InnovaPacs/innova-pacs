package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.StudyEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.StudySpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.StudyJPARepository;
import com.persist.innovapacs.application.ports.out.StudyRepository;
import com.persist.innovapacs.domain.Study;
import com.persist.innovapacs.domain.commons.StudyFilter;
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
public class StudyJPAAdapter implements StudyRepository {
    private final StudyJPARepository studyJPARepository;

    @Override
    public com.persist.innovapacs.domain.commons.Page<Study> findAll(StudyFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<StudyEntity> spec = StudySpecifications.getQuery(filter);
        Page<StudyEntity> studies = studyJPARepository.findAll(spec, pageable);

        return com.persist.innovapacs.domain.commons.Page.<Study>builder()
                .size(studies.getSize())
                .totalPages(studies.getTotalPages())
                .number(studies.getNumber())
                .totalElements(studies.getTotalElements())
                .content(studies.getContent().stream().map(StudyEntity::toDomain).toList())
                .build();
    }

    @Override
    public Study save(Study study) {
        try {

            StudyEntity studyEntity = StudyEntity.fromDomain(study);
            return StudyEntity.toDomain(studyJPARepository.save(studyEntity));

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
    public Study patch(Study study) {
        try {

            Optional<StudyEntity> currentStudy = studyJPARepository.findById(study.getId());
            if (currentStudy.isEmpty()) {
                throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND);
            }

            StudyEntity studyEntity = StudyEntity.patchEntity(study, currentStudy.get());
            return StudyEntity.toDomain(studyJPARepository.save(studyEntity));

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

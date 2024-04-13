package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PatientJPARepository extends PagingAndSortingRepository<PatientEntity, String>, JpaSpecificationExecutor<PatientEntity> {
    Optional<PatientEntity> findByDocumentId(String documentId);
}

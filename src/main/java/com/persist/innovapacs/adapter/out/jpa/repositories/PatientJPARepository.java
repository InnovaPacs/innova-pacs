package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientJPARepository extends PagingAndSortingRepository<PatientEntity, String>, JpaSpecificationExecutor<PatientEntity>, CrudRepository<PatientEntity, String> {
}

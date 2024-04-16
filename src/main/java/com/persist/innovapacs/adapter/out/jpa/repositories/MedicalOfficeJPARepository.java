package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.MedicalOfficeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedicalOfficeJPARepository extends PagingAndSortingRepository<MedicalOfficeEntity, String>, JpaSpecificationExecutor<MedicalOfficeEntity>, CrudRepository<MedicalOfficeEntity, String> {
}

package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.ModalityEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModalityJPARepository extends PagingAndSortingRepository<ModalityEntity, String>, JpaSpecificationExecutor<ModalityEntity>, CrudRepository<ModalityEntity, String> {
}

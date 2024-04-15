package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.PhysicianEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhysicianJPARepository extends PagingAndSortingRepository<PhysicianEntity, String>, JpaSpecificationExecutor<PhysicianEntity>, CrudRepository<PhysicianEntity, String> {
}

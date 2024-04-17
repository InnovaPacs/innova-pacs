package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.StudyEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudyJPARepository extends PagingAndSortingRepository<StudyEntity, String>, JpaSpecificationExecutor<StudyEntity>, CrudRepository<StudyEntity, String> {
}

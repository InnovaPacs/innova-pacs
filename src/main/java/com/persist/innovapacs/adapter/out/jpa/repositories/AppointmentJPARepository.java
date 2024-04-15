package com.persist.innovapacs.adapter.out.jpa.repositories;

import com.persist.innovapacs.adapter.out.jpa.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppointmentJPARepository extends PagingAndSortingRepository<AppointmentEntity, String>, JpaSpecificationExecutor<AppointmentEntity>, CrudRepository<AppointmentEntity, String>  {
}

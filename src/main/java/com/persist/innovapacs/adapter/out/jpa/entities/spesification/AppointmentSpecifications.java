package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.AppointmentEntity;
import com.persist.innovapacs.domain.commons.AppointmentFilter;
import org.springframework.data.jpa.domain.Specification;

public class AppointmentSpecifications {
    private AppointmentSpecifications() {}

    public static Specification<AppointmentEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<AppointmentEntity> filterByMedicalOfficeId(String medicalOfficeId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("medicalOffice").get("id"), medicalOfficeId);
        };
    }

    public static Specification<AppointmentEntity> getQuery(AppointmentFilter patientFilter) {

        Specification<AppointmentEntity> spec = null;


        return spec;
    }
}

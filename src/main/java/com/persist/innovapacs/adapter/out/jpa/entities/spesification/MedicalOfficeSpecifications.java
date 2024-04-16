package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.MedicalOfficeEntity;
import com.persist.innovapacs.domain.commons.MedicalOfficeFilter;
import org.springframework.data.jpa.domain.Specification;

public class MedicalOfficeSpecifications {
    private MedicalOfficeSpecifications() {}

    public static Specification<MedicalOfficeEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<MedicalOfficeEntity> getQuery(MedicalOfficeFilter medicalOfficeFilter) {

        Specification<MedicalOfficeEntity> spec = null;


        return spec;
    }
}

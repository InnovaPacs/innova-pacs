package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.ModalityEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.ModalityFilter;
import org.springframework.data.jpa.domain.Specification;

public class ModalitySpecifications {
    private ModalitySpecifications() {}

    public static Specification<ModalityEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<ModalityEntity> getQuery(ModalityFilter modalityFilter) {

        Specification<ModalityEntity> spec = null;

        if(modalityFilter.getName() != null) {
            spec = spec.or(
                    ModalitySpecifications.containsIgnoreCase("name",modalityFilter.getName()));
        }

        return spec;
    }
}

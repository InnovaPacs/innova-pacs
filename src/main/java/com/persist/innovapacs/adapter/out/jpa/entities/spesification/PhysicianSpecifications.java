package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.PhysicianEntity;
import com.persist.innovapacs.domain.commons.PhysicianFilter;
import org.springframework.data.jpa.domain.Specification;

public class PhysicianSpecifications {
    private PhysicianSpecifications() {}

    public static Specification<PhysicianEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<PhysicianEntity> filterByMedicalOfficeId(String medicalOfficeId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("medicalOffice").get("id"), medicalOfficeId);
        };
    }

    public static Specification<PhysicianEntity> getQuery(PhysicianFilter physicianFilter) {

        Specification<PhysicianEntity> spec = null;

        if(physicianFilter.getDocumentId() != null) {
            spec = spec.or(
                    PhysicianSpecifications.containsIgnoreCase("documentId", physicianFilter.getDocumentId()));
        }

        if(physicianFilter.getFirstName() != null) {
            spec = spec.or(
                    PhysicianSpecifications.containsIgnoreCase("firstName", physicianFilter.getFirstName()));
        }

        if(physicianFilter.getLastName() != null) {
            spec = spec.or(
                    PhysicianSpecifications.containsIgnoreCase("lastName", physicianFilter.getLastName()));
        }

        return spec;
    }
}

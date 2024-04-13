package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.domain.commons.PatientFilter;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecifications {
    private PatientSpecifications() {}

    public static Specification<PatientEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<PatientEntity> filterByMedicalOfficeId(String medicalOfficeId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("medicalOffice").get("id"), medicalOfficeId);
        };
    }

    public static Specification<PatientEntity> getQuery(PatientFilter patientFilter) {

        Specification<PatientEntity> spec = PatientSpecifications.filterByMedicalOfficeId(patientFilter.getMedicalOfficeId());

        if(patientFilter.getDocumentId() != null) {
            spec = spec.or(
                    PatientSpecifications.containsIgnoreCase("documentId", patientFilter.getDocumentId()));
        }

        if(patientFilter.getFirstName() != null) {
            spec = spec.or(
                    PatientSpecifications.containsIgnoreCase("firstName", patientFilter.getFirstName()));
        }

        if(patientFilter.getLastName() != null) {
            spec = spec.or(
                    PatientSpecifications.containsIgnoreCase("lastName", patientFilter.getLastName()));
        }

        return spec;
    }
}

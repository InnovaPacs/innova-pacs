package com.persist.innovapacs.adapter.out.jpa.entities.spesification;

import com.persist.innovapacs.adapter.out.jpa.entities.StudyEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons.StudyFilter;
import org.springframework.data.jpa.domain.Specification;

public class StudySpecifications {
    private StudySpecifications() {}

    public static Specification<StudyEntity> containsIgnoreCase(String column, String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(column)), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<StudyEntity> getQuery(StudyFilter studyFilter) {

        Specification<StudyEntity> spec = null;

        return spec;
    }
}

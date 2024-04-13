package com.persist.innovapacs.adapter.out.jpa;

import com.persist.innovapacs.adapter.out.jpa.entities.PatientEntity;
import com.persist.innovapacs.adapter.out.jpa.entities.spesification.PatientSpecifications;
import com.persist.innovapacs.adapter.out.jpa.repositories.PatientJPARepository;
import com.persist.innovapacs.application.ports.out.PatientRepository;
import com.persist.innovapacs.domain.Patient;
import com.persist.innovapacs.domain.commons.PatientFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PatientJPAAdapter implements PatientRepository {
    private final PatientJPARepository patientJPARepository;

    @Override
    public com.persist.innovapacs.domain.commons.Page<Patient> findAllPatients(PatientFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());

        Specification<PatientEntity> spec = PatientSpecifications.getQuery(filter);

        Page<PatientEntity> patients = patientJPARepository.findAll(spec, pageable);

        return com.persist.innovapacs.domain.commons.Page.<Patient>builder()
                .size(patients.getSize())
                .totalPages(patients.getTotalPages())
                .number(patients.getNumber())
                .totalElements(patients.getTotalElements())
                .content(patients.getContent().stream().map(PatientEntity::toDomain).toList())
                .build();
    }

    @Override
    public Optional<Patient> findByDocumentId(String documentId) {
        return Optional.empty();
    }

    @Override
    public Patient save(Patient patient) {
        PatientEntity patientEntity = PatientEntity.fromDomain(patient);
        return PatientEntity.toDomain(patientJPARepository.save(patientEntity));
    }
}

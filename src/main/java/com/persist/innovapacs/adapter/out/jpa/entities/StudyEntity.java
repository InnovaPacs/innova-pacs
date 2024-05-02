package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.Study;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "studies")
public class StudyEntity {
    @Id()
    String id;
    @Column(name = "study_date")
    LocalDate studyDate;
    @Column(name = "study_type", length = 20)
    String studyType;
    @Column(name = "study_description", length = 100)
    String studyDescription;
    @Column(name = "study_results", length = 400)
    String studyResults;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientEntity patient;
    @ManyToOne
    @JoinColumn(name = "physician_id", referencedColumnName = "id")
    private PhysicianEntity physician;
    @ManyToOne
    @JoinColumn(name = "modality_id", referencedColumnName = "id")
    private ModalityEntity modality;

    public static Study toDomain(StudyEntity study) {

        if (study == null) return null;

        return Study.builder()
                .id(study.getId())
                .studyDate(study.getStudyDate())
                .studyType(study.getStudyType())
                .studyDescription(study.getStudyDescription())
                .studyResults(study.getStudyResults())
                .patient(PatientEntity.toDomain(study.getPatient()))
                .physician(PhysicianEntity.toDomain(study.getPhysician()))
                .modality(ModalityEntity.toDomain(study.getModality()))
                .build();
    }

    public static StudyEntity fromDomain(Study study) {

        if (study == null) return null;

        return StudyEntity.builder()
                .id(study.getId())
                .studyDate(study.getStudyDate())
                .studyType(study.getStudyType())
                .studyDescription(study.getStudyDescription())
                .studyResults(study.getStudyResults())
                .patient(PatientEntity.fromDomain(study.getPatient()))
                .physician(PhysicianEntity.fromDomain(study.getPhysician()))
                .modality(ModalityEntity.fromDomain(study.getModality()))
                .build();
    }

    public static StudyEntity patchEntity(Study study, StudyEntity currentStudy) {
        return StudyEntity.builder()
                .studyDate(study.getStudyDate() != null ? study.getStudyDate() : currentStudy.getStudyDate())
                .studyType(study.getStudyType() != null ? study.getStudyType() : currentStudy.getStudyType())
                .studyDescription(study.getStudyDescription() != null ? study.getStudyDescription() : currentStudy.getStudyDescription())
                .studyResults(study.getStudyResults() != null ? study.getStudyResults() : currentStudy.getStudyResults())
                .build();
    }
}

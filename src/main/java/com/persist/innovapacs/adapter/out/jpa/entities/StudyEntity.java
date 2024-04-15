package com.persist.innovapacs.adapter.out.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "patient_id")
    String patientId;
    @Column(name = "physician_id")
    String physicianId;
    @Column(name = "study_date")
    LocalDate studyDate;
    @Column(name = "modality", length = 20)
    String modality;
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
}

package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.Modality;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modalities")
public class ModalityEntity {
	@Id()
	String id;
	@Column
	String name;
	@Column
	String description;

	public static Modality toDomain(ModalityEntity modality) {

		if(modality == null) return null;

		return Modality.builder()
				.id(modality.getId())
				.name(modality.getName())
				.description(modality.getDescription())
				.build();
	}

	public static ModalityEntity fromDomain(Modality modality) {
		return ModalityEntity.builder()
				.id(modality.getId())
				.name(modality.getName())
				.description(modality.getDescription())
				.build();
	}

	public static ModalityEntity patchEntity(Modality modality, ModalityEntity currentModality) {
		return ModalityEntity.builder()
				.id(modality.getId())
				.name(modality.getName() != null ? modality.getName() : currentModality.getName())
				.description(modality.getDescription() != null ? modality.getDescription() : currentModality.getDescription())
				.build();
	}
}

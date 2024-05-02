package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.persist.innovapacs.domain.Modality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class ModalityRestModel {
	String id;
	String name;
	String description;

	public static ModalityRestModel fromDomain(Modality modality) {
		if (modality == null) return null;

		return ModalityRestModel.builder()
				.id(modality.getId())
				.name(modality.getName())
				.description(modality.getDescription())
				.build();
	}

	public static Modality toDomain(ModalityRestModel modality) {
		if (modality == null) return null;

		return Modality.builder()
				.id(modality.getId())
				.name(modality.getName())
				.description(modality.getDescription())
				.build();
	}
}

package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Modality {
	String id;
	String name;
	String description;
}

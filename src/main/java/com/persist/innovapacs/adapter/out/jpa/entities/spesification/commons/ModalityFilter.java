package com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModalityFilter {
    Integer page;
    Integer size;
    String name;
}

package com.persist.innovapacs.adapter.out.jpa.entities.spesification.commons;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Page<T> {
    List<T> content;
    long totalElements;
    int size;
    int number;
    int totalPages;
}

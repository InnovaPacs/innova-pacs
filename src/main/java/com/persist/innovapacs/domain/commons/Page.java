package com.persist.innovapacs.domain.commons;

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

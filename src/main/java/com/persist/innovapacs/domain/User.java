package com.persist.innovapacs.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String id;
    String email;
    String status;
}

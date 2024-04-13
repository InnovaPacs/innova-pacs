package com.persist.innovapacs.adapter.in.rest.model;

import com.persist.innovapacs.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRestModel {
    String id;
    String email;
    String status;

    public static UserRestModel fromDomain(User user) {
        return UserRestModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}
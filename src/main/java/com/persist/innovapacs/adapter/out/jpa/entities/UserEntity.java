package com.persist.innovapacs.adapter.out.jpa.entities;

import com.persist.innovapacs.domain.User;
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
@Table(name = "users")
public class UserEntity {
    @Id()
    String id;
    @Column
    String email;
    @Column
    String password;
    @Column
    String status;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public static User toDomain(UserEntity user) {
        if ( user == null ) return  null;

        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}

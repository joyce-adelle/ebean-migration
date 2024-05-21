package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.util.AuthProvider;
import org.example.util.Role;

import java.time.Instant;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app-user")
@Entity
public class AppUser {

    @Id
    private String id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "provider_id", length = 50)
    private String providerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "provider", updatable = false, columnDefinition = "varchar(20) default 'LOCAL'")
    private AuthProvider provider;

    @Column(name = "verified_at")
    private Instant verifiedAt;

    @Column(name = "created_at", updatable = false)
    @WhenCreated
    private Instant createdAt;

    @Column(name = "updated_at")
    @WhenModified
    private Instant updatedAt;

    @Column(name = "deactivated_by")
    private String deactivatedBy;

    @Column(name = "deactivated_at")
    private Instant deactivatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

}

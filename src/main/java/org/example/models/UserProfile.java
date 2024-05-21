package org.example.models;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

import static jakarta.persistence.FetchType.LAZY;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user-profile")
@Entity
public class UserProfile {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters long")
    @Column(name = "name", length = 100)
    private String name;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AppUser user;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "created_at", updatable = false)
    @WhenCreated
    private Instant createdAt;

    @Column(name = "updated_at")
    @WhenModified
    private Instant updatedAt;

}

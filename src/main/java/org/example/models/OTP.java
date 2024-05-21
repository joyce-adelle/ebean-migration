package org.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OTP {

    @Id
    @Email(message = "Invalid email")
    private String email;

    @NotNull
    private String otp;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @NotNull
    @Column(name = "expired_at")
    private Instant expiredAt;

    @Column(name = "confirmed_at")
    private Instant confirmedAt;

}

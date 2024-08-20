package org.example.models;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating")
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SheetMusic sheetMusic;

    @ManyToOne
    private String userId;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rate;

    @Column(name = "created_at")
    @WhenCreated
    private Instant createdAt;

    @Column(name = "updated_at")
    @WhenModified
    private Instant updatedAt;

}

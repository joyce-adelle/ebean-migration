package org.example.models;

import io.ebean.annotation.DbDefault;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.util.KeySignature;
import org.example.util.Tempo;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sheet-music")
public class SheetMusic {

    @Id
    private String id;

    @NotNull
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    private String lyricist;

    private String composer;

    private String arranger;

    @Enumerated(EnumType.STRING)
    private Tempo tempo;

    @Enumerated(EnumType.STRING)
    @Column(name = "key_signature")
    private KeySignature keySignature;

    @Column(name = "time_signature_numerator")
    private Integer timeSignatureNumerator;

    @Column(name = "time_signature_denominator")
    private Integer timeSignatureDenominator;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "cover_image_path")
    private String coverImagePath;

    @NotNull
    @Column(name = "average_rating", precision = 8, scale = 2)
    private Double averageRating;

    @NotNull
    @Min(0)
    @Column(name = "rating_count")
    private Long ratingCount;

    @NotNull
    @Column(name = "uploaded_by_id")
    private String uploadedById;

    @Column(columnDefinition = "boolean default false not null")
    private Boolean approved;

    @Column(columnDefinition = "boolean default false not null")
    private Boolean enabled;

    @Column(name = "extracted_text", columnDefinition = "TEXT")
    private String extractedText;

    @Column(name = "last_viewed_at")
    private Instant lastViewedAt;

    @NotNull
    @Min(0)
    @DbDefault("0")
    @Column(name = "view_count")
    private Long viewCount;

    @ManyToMany
    @JoinTable(
            name = "sheet_music_categories",
            joinColumns = @JoinColumn(name = "sheet_music_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "sheet_music_audios",
            joinColumns = @JoinColumn(name = "sheet_music_id"),
            inverseJoinColumns = @JoinColumn(name = "audio_id")
    )
    private Set<Audio> audios = new HashSet<>();

    @OneToMany(mappedBy = "sheetMusic", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings = new HashSet<>();

}

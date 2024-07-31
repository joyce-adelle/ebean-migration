package org.example.models;

import io.ebean.annotation.WhenCreated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.example.util.SheetMusicLifecycleLogEvent;

import java.time.Instant;

@Entity
@Table(name = "lifecycle-log")
public class LifecycleLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column( name = "sheet_music_id")
//    private String sheetMusicId;

    @ManyToOne
    private SheetMusic sheetMusic;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "event", updatable = false)
    private SheetMusicLifecycleLogEvent event;

    @NotNull
    private String userId;

    @Column(name = "log_time", updatable = false)
    @WhenCreated
    private Instant logTime;

    @Column(columnDefinition = "TEXT")
    private String details;

}

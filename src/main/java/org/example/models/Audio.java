package org.example.models;

import jakarta.persistence.*;

@Entity
@Table( name = "audio")
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_format")
    private String fileFormat;

    @Column(name = "file_size_bytes")
    private Long fileSizeBytes;

    private String duration;

    private Integer bpm;

}

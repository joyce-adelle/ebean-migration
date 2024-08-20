package org.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(2)
    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "has_children")
    private boolean hasChildren;

    @Column(name = "has_parents")
    private boolean hasParents;

    @ManyToMany
    @JoinTable(
            name = "category_relationship",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<Category> children = new HashSet<>();

    @ManyToMany(mappedBy = "children")
    @JoinTable(
            name = "category_relationship",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Category> parents = new HashSet<>();

}

package com.example.bookapp.domain.tags;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID uuid;
    @Column(unique = true)
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(){}

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

}

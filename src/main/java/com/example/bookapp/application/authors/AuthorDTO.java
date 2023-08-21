package com.example.bookapp.application.authors;

import com.example.bookapp.domain.authors.Author;

import java.util.UUID;

public class AuthorDTO {
    private UUID uuid;
    private String name;

    public AuthorDTO(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public static AuthorDTO from(Author author) {
        return new AuthorDTO(
                author.getUuid(),
                author.getName()
        );
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}

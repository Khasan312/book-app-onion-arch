package com.example.bookapp.infrastructure.authors.controllers.responses;

import com.example.bookapp.domain.authors.Author;

import java.util.UUID;

public class AuthorResponse {
    public UUID uuid;
    public String name;

    public static AuthorResponse from(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.uuid = author.getUuid();
        response.name = author.getName();
        return response;
    }
}

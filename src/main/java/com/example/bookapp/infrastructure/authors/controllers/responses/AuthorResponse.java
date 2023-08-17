package com.example.bookapp.infrastructure.authors.controllers.responses;

import com.example.bookapp.application.authors.AuthorDTO;

import java.util.UUID;

public class AuthorResponse {
    public UUID uuid;
    public String name;

    public static AuthorResponse from(AuthorDTO author) {
        AuthorResponse response = new AuthorResponse();
        response.uuid = author.getUuid();
        response.name = author.getName();
        return response;
    }
}

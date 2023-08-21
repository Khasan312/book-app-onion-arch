package com.example.bookapp.application.authors;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;

import java.util.UUID;

public class UpdateAuthorInput {
    public UUID uuid;
    public String name;

    public UpdateAuthorInput(UUID uuid,String name) {
        this.name = name;
        this.uuid = uuid;
    }

    public UUID uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }
}

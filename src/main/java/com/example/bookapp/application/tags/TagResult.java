package com.example.bookapp.application.tags;

import java.util.UUID;

public class TagResult {
    private UUID uuid;
    private String name;

    public TagResult(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }
}

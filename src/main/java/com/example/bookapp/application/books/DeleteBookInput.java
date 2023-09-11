package com.example.bookapp.application.books;

import java.util.UUID;

public class DeleteBookInput {
    private UUID uuid;

    public DeleteBookInput(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}

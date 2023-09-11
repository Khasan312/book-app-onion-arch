package com.example.bookapp.application.authors;

import java.util.UUID;

public class DeleteAuthorInput {
    private UUID uuid;

    public DeleteAuthorInput(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}

package com.example.bookapp.application.books;

import java.util.UUID;

public class GetBookInput {
    private UUID uuid;

    public GetBookInput(UUID uuid) {
        this.uuid = uuid;

    }

    public UUID uuid() {
        return uuid;
    }


}

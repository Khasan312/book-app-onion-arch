package com.example.bookapp.application.books;

import java.util.UUID;

public class UpdateBookInput {
    private UUID uuid;
    private BookInfo info;
    private BookBy bookBy;

    public UpdateBookInput(UUID uuid, BookInfo info, BookBy bookBy) {
        this.uuid = uuid;
        this.info = info;
        this.bookBy = bookBy;

    }

    public UUID uuid() {
        return uuid;
    }

    public BookInfo info() {
        return info;
    }

    public BookBy bookBy() {
        return bookBy;
    }


}
